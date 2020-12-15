package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes22.dex */
public class a implements View.OnClickListener {
    private b fZo;
    private AccountSafeModel fZp;
    private final BaseActivity mActivity;
    private com.baidu.adp.framework.listener.a mNetMessagelistener = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.fZp != null) {
                a.this.fZp.setLoading(false);
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
                if (a.this.fZp != null) {
                    a.this.fZp.a(aVar);
                }
                if (a.this.fZo != null && a.this.fZp != null && a.this.fZp.bMh() != null) {
                    a.this.fZo.a(a.this.fZp.bMh().bMl());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.registerListener(this.mNetMessagelistener);
        this.fZo = new b(this.mActivity, this);
        this.fZp = new AccountSafeModel(this.mActivity);
        if (j.isNetWorkAvailable()) {
            bMm();
        } else {
            this.mActivity.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.fZo.getView();
    }

    private void bMm() {
        if (this.fZp != null && !this.fZp.isLoading()) {
            this.fZp.bMj();
        }
    }

    public void onDestroy() {
        this.mActivity.closeLoadingDialog();
        if (this.fZp != null) {
            this.fZp.cancelLoadData();
        }
        if (this.fZo != null) {
            this.fZo.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fZo != null) {
            this.fZo.rY(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.isNetWorkAvailable()) {
                this.mActivity.showToast(R.string.neterror);
            } else {
                bf.bua().b(this.mActivity.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.bo(this.mActivity, this.fZp != null ? this.fZp.Fk() : "");
        }
    }
}
