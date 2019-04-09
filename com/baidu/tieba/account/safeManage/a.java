package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private final BaseActivity cNd;
    private b cNe;
    private AccountSafeModel cNf;
    private com.baidu.adp.framework.listener.a cNg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cNf != null) {
                a.this.cNf.setLoading(false);
            }
            a.this.cNd.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cNd.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cNd.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cNf != null) {
                    a.this.cNf.a(aVar);
                }
                if (a.this.cNe != null && a.this.cNf != null && a.this.cNf.awu() != null) {
                    a.this.cNe.a(a.this.cNf.awu().awz());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cNd = baseActivity;
        this.cNd.registerListener(this.cNg);
        this.cNe = new b(this.cNd, this);
        this.cNf = new AccountSafeModel(this.cNd);
        if (j.kY()) {
            awA();
        } else {
            this.cNd.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.cNe.getView();
    }

    private void awA() {
        if (this.cNf != null && !this.cNf.qz()) {
            this.cNf.awx();
        }
    }

    public void onDestroy() {
        this.cNd.closeLoadingDialog();
        if (this.cNf != null) {
            this.cNf.cancelLoadData();
        }
        if (this.cNe != null) {
            this.cNe.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cNe != null) {
            this.cNe.jf(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kY()) {
                this.cNd.showToast(d.j.neterror);
            } else {
                ba.adA().c(this.cNd.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.aV(this.cNd, this.cNf != null ? this.cNf.awv() : "");
        }
    }
}
