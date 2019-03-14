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
    private final BaseActivity cNa;
    private b cNb;
    private AccountSafeModel cNc;
    private com.baidu.adp.framework.listener.a cNd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cNc != null) {
                a.this.cNc.setLoading(false);
            }
            a.this.cNa.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cNa.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cNa.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cNc != null) {
                    a.this.cNc.a(aVar);
                }
                if (a.this.cNb != null && a.this.cNc != null && a.this.cNc.awx() != null) {
                    a.this.cNb.a(a.this.cNc.awx().awC());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cNa = baseActivity;
        this.cNa.registerListener(this.cNd);
        this.cNb = new b(this.cNa, this);
        this.cNc = new AccountSafeModel(this.cNa);
        if (j.kY()) {
            awD();
        } else {
            this.cNa.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.cNb.getView();
    }

    private void awD() {
        if (this.cNc != null && !this.cNc.qz()) {
            this.cNc.awA();
        }
    }

    public void onDestroy() {
        this.cNa.closeLoadingDialog();
        if (this.cNc != null) {
            this.cNc.cancelLoadData();
        }
        if (this.cNb != null) {
            this.cNb.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cNb != null) {
            this.cNb.jg(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kY()) {
                this.cNa.showToast(d.j.neterror);
            } else {
                ba.adD().c(this.cNa.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.aV(this.cNa, this.cNc != null ? this.cNc.awy() : "");
        }
    }
}
