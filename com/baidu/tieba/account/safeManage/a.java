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
    private final BaseActivity bSO;
    private b bSP;
    private AccountSafeModel bSQ;
    private com.baidu.adp.framework.listener.a bSR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bSQ != null) {
                a.this.bSQ.setLoading(false);
            }
            a.this.bSO.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bSO.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bSO.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bSQ != null) {
                    a.this.bSQ.a(aVar);
                }
                if (a.this.bSP != null && a.this.bSQ != null && a.this.bSQ.Ut() != null) {
                    a.this.bSP.a(a.this.bSQ.Ut().Uy());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bSO = baseActivity;
        this.bSO.registerListener(this.bSR);
        this.bSP = new b(this.bSO, this);
        this.bSQ = new AccountSafeModel(this.bSO);
        if (j.oJ()) {
            Uz();
        } else {
            this.bSO.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.bSP.getView();
    }

    private void Uz() {
        if (this.bSQ != null && !this.bSQ.El()) {
            this.bSQ.Uw();
        }
    }

    public void onDestroy() {
        this.bSO.closeLoadingDialog();
        if (this.bSQ != null) {
            this.bSQ.cancelLoadData();
        }
        if (this.bSP != null) {
            this.bSP.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bSP != null) {
            this.bSP.hr(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.oJ()) {
                this.bSO.showToast(d.j.neterror);
            } else {
                aw.Du().c(this.bSO.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.as(this.bSO, this.bSQ != null ? this.bSQ.Uu() : "");
        }
    }
}
