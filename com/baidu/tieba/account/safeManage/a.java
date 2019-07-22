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
    private final BaseActivity cWM;
    private b cWN;
    private AccountSafeModel cWO;
    private com.baidu.adp.framework.listener.a cWP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cWO != null) {
                a.this.cWO.setLoading(false);
            }
            a.this.cWM.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cWM.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cWM.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cWO != null) {
                    a.this.cWO.a(aVar);
                }
                if (a.this.cWN != null && a.this.cWO != null && a.this.cWO.aCS() != null) {
                    a.this.cWN.a(a.this.cWO.aCS().aCX());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cWM = baseActivity;
        this.cWM.registerListener(this.cWP);
        this.cWN = new b(this.cWM, this);
        this.cWO = new AccountSafeModel(this.cWM);
        if (j.kc()) {
            aCY();
        } else {
            this.cWM.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.cWN.getView();
    }

    private void aCY() {
        if (this.cWO != null && !this.cWO.pP()) {
            this.cWO.aCV();
        }
    }

    public void onDestroy() {
        this.cWM.closeLoadingDialog();
        if (this.cWO != null) {
            this.cWO.cancelLoadData();
        }
        if (this.cWN != null) {
            this.cWN.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cWN != null) {
            this.cWN.jZ(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kc()) {
                this.cWM.showToast(R.string.neterror);
            } else {
                bb.ajC().c(this.cWM.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aK(this.cWM, this.cWO != null ? this.cWO.aCT() : "");
        }
    }
}
