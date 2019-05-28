package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private final BaseActivity cVp;
    private b cVq;
    private AccountSafeModel cVr;
    private com.baidu.adp.framework.listener.a cVs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cVr != null) {
                a.this.cVr.setLoading(false);
            }
            a.this.cVp.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cVp.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cVp.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cVr != null) {
                    a.this.cVr.a(aVar);
                }
                if (a.this.cVq != null && a.this.cVr != null && a.this.cVr.aBD() != null) {
                    a.this.cVq.a(a.this.cVr.aBD().aBI());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cVp = baseActivity;
        this.cVp.registerListener(this.cVs);
        this.cVq = new b(this.cVp, this);
        this.cVr = new AccountSafeModel(this.cVp);
        if (j.jS()) {
            aBJ();
        } else {
            this.cVp.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.cVq.getView();
    }

    private void aBJ() {
        if (this.cVr != null && !this.cVr.pu()) {
            this.cVr.aBG();
        }
    }

    public void onDestroy() {
        this.cVp.closeLoadingDialog();
        if (this.cVr != null) {
            this.cVr.cancelLoadData();
        }
        if (this.cVq != null) {
            this.cVq.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cVq != null) {
            this.cVq.jT(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jS()) {
                this.cVp.showToast(R.string.neterror);
            } else {
                ba.aiz().c(this.cVp.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aJ(this.cVp, this.cVr != null ? this.cVr.aBE() : "");
        }
    }
}
