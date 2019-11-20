package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private b dgs;
    private AccountSafeModel dgt;
    private final BaseActivity mActivity;
    private com.baidu.adp.framework.listener.a mNetMessagelistener = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.dgt != null) {
                a.this.dgt.setLoading(false);
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
                if (a.this.dgt != null) {
                    a.this.dgt.a(aVar);
                }
                if (a.this.dgs != null && a.this.dgt != null && a.this.dgt.aDp() != null) {
                    a.this.dgs.a(a.this.dgt.aDp().aDu());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.registerListener(this.mNetMessagelistener);
        this.dgs = new b(this.mActivity, this);
        this.dgt = new AccountSafeModel(this.mActivity);
        if (j.isNetWorkAvailable()) {
            aDv();
        } else {
            this.mActivity.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.dgs.getView();
    }

    private void aDv() {
        if (this.dgt != null && !this.dgt.isLoading()) {
            this.dgt.aDs();
        }
    }

    public void onDestroy() {
        this.mActivity.closeLoadingDialog();
        if (this.dgt != null) {
            this.dgt.cancelLoadData();
        }
        if (this.dgs != null) {
            this.dgs.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dgs != null) {
            this.dgs.jz(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.isNetWorkAvailable()) {
                this.mActivity.showToast(R.string.neterror);
            } else {
                ba.amO().b(this.mActivity.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aT(this.mActivity, this.dgt != null ? this.dgt.aDq() : "");
        }
    }
}
