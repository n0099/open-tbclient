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
    private final BaseActivity cVq;
    private b cVr;
    private AccountSafeModel cVs;
    private com.baidu.adp.framework.listener.a cVt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cVs != null) {
                a.this.cVs.setLoading(false);
            }
            a.this.cVq.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cVq.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cVq.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cVs != null) {
                    a.this.cVs.a(aVar);
                }
                if (a.this.cVr != null && a.this.cVs != null && a.this.cVs.aBD() != null) {
                    a.this.cVr.a(a.this.cVs.aBD().aBI());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cVq = baseActivity;
        this.cVq.registerListener(this.cVt);
        this.cVr = new b(this.cVq, this);
        this.cVs = new AccountSafeModel(this.cVq);
        if (j.jS()) {
            aBJ();
        } else {
            this.cVq.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.cVr.getView();
    }

    private void aBJ() {
        if (this.cVs != null && !this.cVs.pu()) {
            this.cVs.aBG();
        }
    }

    public void onDestroy() {
        this.cVq.closeLoadingDialog();
        if (this.cVs != null) {
            this.cVs.cancelLoadData();
        }
        if (this.cVr != null) {
            this.cVr.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cVr != null) {
            this.cVr.jT(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jS()) {
                this.cVq.showToast(R.string.neterror);
            } else {
                ba.aiz().c(this.cVq.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aJ(this.cVq, this.cVs != null ? this.cVs.aBE() : "");
        }
    }
}
