package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bsQ;
    private b bsR;
    private AccountSafeModel bsS;
    private com.baidu.adp.framework.listener.a bsT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bsS != null) {
                a.this.bsS.setLoading(false);
            }
            a.this.bsQ.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bsQ.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bsQ.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bsS != null) {
                    a.this.bsS.a(aVar);
                }
                if (a.this.bsR != null && a.this.bsS != null && a.this.bsS.SO() != null) {
                    a.this.bsR.a(a.this.bsS.SO().ST());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bsQ = baseActivity;
        this.bsQ.registerListener(this.bsT);
        this.bsR = new b(this.bsQ, this);
        this.bsS = new AccountSafeModel(this.bsQ);
        if (j.kK()) {
            SU();
        } else {
            this.bsQ.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bsR.getView();
    }

    private void SU() {
        if (this.bsS != null && !this.bsS.BO()) {
            this.bsS.SR();
        }
    }

    public void onDestroy() {
        this.bsQ.closeLoadingDialog();
        if (this.bsS != null) {
            this.bsS.cancelLoadData();
        }
        if (this.bsR != null) {
            this.bsR.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bsR != null) {
            this.bsR.eJ(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kK()) {
                this.bsQ.showToast(e.j.neterror);
            } else {
                ay.AN().c(this.bsQ.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aH(this.bsQ, this.bsS != null ? this.bsS.SP() : "");
        }
    }
}
