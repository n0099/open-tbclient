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
    private final BaseActivity cXM;
    private b cXN;
    private AccountSafeModel cXO;
    private com.baidu.adp.framework.listener.a cXP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.cXO != null) {
                a.this.cXO.setLoading(false);
            }
            a.this.cXM.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.cXM.getString(R.string.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.cXM.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.cXO != null) {
                    a.this.cXO.a(aVar);
                }
                if (a.this.cXN != null && a.this.cXO != null && a.this.cXO.aDi() != null) {
                    a.this.cXN.a(a.this.cXO.aDi().aDn());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.cXM = baseActivity;
        this.cXM.registerListener(this.cXP);
        this.cXN = new b(this.cXM, this);
        this.cXO = new AccountSafeModel(this.cXM);
        if (j.kc()) {
            aDo();
        } else {
            this.cXM.showToast(R.string.neterror);
        }
    }

    public View getRootView() {
        return this.cXN.getView();
    }

    private void aDo() {
        if (this.cXO != null && !this.cXO.pQ()) {
            this.cXO.aDl();
        }
    }

    public void onDestroy() {
        this.cXM.closeLoadingDialog();
        if (this.cXO != null) {
            this.cXO.cancelLoadData();
        }
        if (this.cXN != null) {
            this.cXN.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cXN != null) {
            this.cXN.kd(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kc()) {
                this.cXM.showToast(R.string.neterror);
            } else {
                ba.ajK().c(this.cXM.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == R.id.account_status) {
            AntiHelper.aR(this.cXM, this.cXO != null ? this.cXO.aDj() : "");
        }
    }
}
