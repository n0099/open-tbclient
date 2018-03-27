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
    private final BaseActivity bSF;
    private b bSG;
    private AccountSafeModel bSH;
    private com.baidu.adp.framework.listener.a bSI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bSH != null) {
                a.this.bSH.setLoading(false);
            }
            a.this.bSF.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bSF.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bSF.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bSH != null) {
                    a.this.bSH.a(aVar);
                }
                if (a.this.bSG != null && a.this.bSH != null && a.this.bSH.Ut() != null) {
                    a.this.bSG.a(a.this.bSH.Ut().Uy());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bSF = baseActivity;
        this.bSF.registerListener(this.bSI);
        this.bSG = new b(this.bSF, this);
        this.bSH = new AccountSafeModel(this.bSF);
        if (j.oJ()) {
            Uz();
        } else {
            this.bSF.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.bSG.getView();
    }

    private void Uz() {
        if (this.bSH != null && !this.bSH.El()) {
            this.bSH.Uw();
        }
    }

    public void onDestroy() {
        this.bSF.closeLoadingDialog();
        if (this.bSH != null) {
            this.bSH.cancelLoadData();
        }
        if (this.bSG != null) {
            this.bSG.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bSG != null) {
            this.bSG.hr(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.oJ()) {
                this.bSF.showToast(d.j.neterror);
            } else {
                aw.Du().c(this.bSF.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.as(this.bSF, this.bSH != null ? this.bSH.Uu() : "");
        }
    }
}
