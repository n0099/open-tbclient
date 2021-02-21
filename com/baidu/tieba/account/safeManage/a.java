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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private b ggG;
    private AccountSafeModel ggH;
    private final BaseActivity mActivity;
    private com.baidu.adp.framework.listener.a mNetMessagelistener = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.ggH != null) {
                a.this.ggH.setLoading(false);
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
                if (a.this.ggH != null) {
                    a.this.ggH.a(aVar);
                }
                if (a.this.ggG != null && a.this.ggH != null && a.this.ggH.bLh() != null) {
                    a.this.ggG.a(a.this.ggH.bLh().bLl());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.registerListener(this.mNetMessagelistener);
        this.ggG = new b(this.mActivity, this);
        this.ggH = new AccountSafeModel(this.mActivity);
        if (j.isNetWorkAvailable()) {
            bLm();
        } else {
            this.mActivity.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.ggG.getView();
    }

    private void bLm() {
        if (this.ggH != null && !this.ggH.isLoading()) {
            this.ggH.bLj();
        }
    }

    public void onDestroy() {
        this.mActivity.closeLoadingDialog();
        if (this.ggH != null) {
            this.ggH.cancelLoadData();
        }
        if (this.ggG != null) {
            this.ggG.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ggG != null) {
            this.ggG.qJ(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.isNetWorkAvailable()) {
                this.mActivity.showToast(R.string.neterror);
            } else {
                bf.bsV().b(this.mActivity.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.br(this.mActivity, this.ggH != null ? this.ggH.BS() : "");
        }
    }
}
