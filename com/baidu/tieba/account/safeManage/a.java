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
    private final BaseActivity cVo;
    private b cVp;
    private AccountSafeModel cVq;
    private com.baidu.adp.framework.listener.a cVr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cVq != null) {
                a.this.cVq.setLoading(false);
            }
            a.this.cVo.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cVo.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cVo.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cVq != null) {
                    a.this.cVq.a(aVar);
                }
                if (a.this.cVp != null && a.this.cVq != null && a.this.cVq.aBA() != null) {
                    a.this.cVp.a(a.this.cVq.aBA().aBF());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cVo = baseActivity;
        this.cVo.registerListener(this.cVr);
        this.cVp = new b(this.cVo, this);
        this.cVq = new AccountSafeModel(this.cVo);
        if (j.jS()) {
            aBG();
        } else {
            this.cVo.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.cVp.getView();
    }

    private void aBG() {
        if (this.cVq != null && !this.cVq.pu()) {
            this.cVq.aBD();
        }
    }

    public void onDestroy() {
        this.cVo.closeLoadingDialog();
        if (this.cVq != null) {
            this.cVq.cancelLoadData();
        }
        if (this.cVp != null) {
            this.cVp.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cVp != null) {
            this.cVp.jT(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jS()) {
                this.cVo.showToast(R.string.neterror);
            } else {
                ba.aiz().c(this.cVo.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aJ(this.cVo, this.cVq != null ? this.cVq.aBB() : "");
        }
    }
}
