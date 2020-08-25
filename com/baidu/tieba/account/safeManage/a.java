package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes16.dex */
public class a implements View.OnClickListener {
    private b fnO;
    private AccountSafeModel fnP;
    private final BaseActivity mActivity;
    private com.baidu.adp.framework.listener.a mNetMessagelistener = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.fnP != null) {
                a.this.fnP.setLoading(false);
            }
            a.this.mActivity.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.mActivity.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.mActivity.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.fnP != null) {
                    a.this.fnP.a(aVar);
                }
                if (a.this.fnO != null && a.this.fnP != null && a.this.fnP.bAN() != null) {
                    a.this.fnO.a(a.this.fnP.bAN().bAR());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.registerListener(this.mNetMessagelistener);
        this.fnO = new b(this.mActivity, this);
        this.fnP = new AccountSafeModel(this.mActivity);
        if (j.isNetWorkAvailable()) {
            bAS();
        } else {
            this.mActivity.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.fnO.getView();
    }

    private void bAS() {
        if (this.fnP != null && !this.fnP.isLoading()) {
            this.fnP.bAP();
        }
    }

    public void onDestroy() {
        this.mActivity.closeLoadingDialog();
        if (this.fnP != null) {
            this.fnP.cancelLoadData();
        }
        if (this.fnO != null) {
            this.fnO.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fnO != null) {
            this.fnO.pT(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.isNetWorkAvailable()) {
                this.mActivity.showToast(R.string.neterror);
            } else {
                be.bju().b(this.mActivity.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.bc(this.mActivity, this.fnP != null ? this.fnP.Cv() : "");
        }
    }
}
