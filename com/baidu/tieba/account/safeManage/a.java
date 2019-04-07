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
    private final BaseActivity cNc;
    private b cNd;
    private AccountSafeModel cNe;
    private com.baidu.adp.framework.listener.a cNf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cNe != null) {
                a.this.cNe.setLoading(false);
            }
            a.this.cNc.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cNc.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cNc.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cNe != null) {
                    a.this.cNe.a(aVar);
                }
                if (a.this.cNd != null && a.this.cNe != null && a.this.cNe.awu() != null) {
                    a.this.cNd.a(a.this.cNe.awu().awz());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cNc = baseActivity;
        this.cNc.registerListener(this.cNf);
        this.cNd = new b(this.cNc, this);
        this.cNe = new AccountSafeModel(this.cNc);
        if (j.kY()) {
            awA();
        } else {
            this.cNc.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.cNd.getView();
    }

    private void awA() {
        if (this.cNe != null && !this.cNe.qz()) {
            this.cNe.awx();
        }
    }

    public void onDestroy() {
        this.cNc.closeLoadingDialog();
        if (this.cNe != null) {
            this.cNe.cancelLoadData();
        }
        if (this.cNd != null) {
            this.cNd.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cNd != null) {
            this.cNd.jf(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kY()) {
                this.cNc.showToast(d.j.neterror);
            } else {
                ba.adA().c(this.cNc.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.aV(this.cNc, this.cNe != null ? this.cNe.awv() : "");
        }
    }
}
