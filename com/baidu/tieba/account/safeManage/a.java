package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bSC;
    private b bSD;
    private AccountSafeModel bSE;
    private com.baidu.adp.framework.listener.a bSF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bSE != null) {
                a.this.bSE.setLoading(false);
            }
            a.this.bSC.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bSC.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bSC.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bSE != null) {
                    a.this.bSE.a(aVar);
                }
                if (a.this.bSD != null && a.this.bSE != null && a.this.bSE.Us() != null) {
                    a.this.bSD.a(a.this.bSE.Us().Ux());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bSC = baseActivity;
        this.bSC.registerListener(this.bSF);
        this.bSD = new b(this.bSC, this);
        this.bSE = new AccountSafeModel(this.bSC);
        if (j.oJ()) {
            Uy();
        } else {
            this.bSC.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.bSD.getView();
    }

    private void Uy() {
        if (this.bSE != null && !this.bSE.Ek()) {
            this.bSE.Uv();
        }
    }

    public void onDestroy() {
        this.bSC.closeLoadingDialog();
        if (this.bSE != null) {
            this.bSE.cancelLoadData();
        }
        if (this.bSD != null) {
            this.bSD.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bSD != null) {
            this.bSD.hr(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.oJ()) {
                this.bSC.showToast(d.j.neterror);
            } else {
                aw.Dt().c(this.bSC.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.as(this.bSC, this.bSE != null ? this.bSE.Ut() : "");
        }
    }
}
