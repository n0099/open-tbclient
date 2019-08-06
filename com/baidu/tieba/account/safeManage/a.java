package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private final BaseActivity cWT;
    private b cWU;
    private AccountSafeModel cWV;
    private com.baidu.adp.framework.listener.a cWW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cWV != null) {
                a.this.cWV.setLoading(false);
            }
            a.this.cWT.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cWT.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cWT.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cWV != null) {
                    a.this.cWV.a(aVar);
                }
                if (a.this.cWU != null && a.this.cWV != null && a.this.cWV.aCU() != null) {
                    a.this.cWU.a(a.this.cWV.aCU().aCZ());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cWT = baseActivity;
        this.cWT.registerListener(this.cWW);
        this.cWU = new b(this.cWT, this);
        this.cWV = new AccountSafeModel(this.cWT);
        if (j.kc()) {
            aDa();
        } else {
            this.cWT.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.cWU.getView();
    }

    private void aDa() {
        if (this.cWV != null && !this.cWV.pP()) {
            this.cWV.aCX();
        }
    }

    public void onDestroy() {
        this.cWT.closeLoadingDialog();
        if (this.cWV != null) {
            this.cWV.cancelLoadData();
        }
        if (this.cWU != null) {
            this.cWU.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cWU != null) {
            this.cWU.ka(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kc()) {
                this.cWT.showToast(R.string.neterror);
            } else {
                bb.ajE().c(this.cWT.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aK(this.cWT, this.cWV != null ? this.cWV.aCV() : "");
        }
    }
}
