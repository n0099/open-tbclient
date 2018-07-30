package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bmZ;
    private b bna;
    private AccountSafeModel bnb;
    private com.baidu.adp.framework.listener.a bnc = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bnb != null) {
                a.this.bnb.setLoading(false);
            }
            a.this.bmZ.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bmZ.getString(d.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bmZ.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bnb != null) {
                    a.this.bnb.a(aVar);
                }
                if (a.this.bna != null && a.this.bnb != null && a.this.bnb.QV() != null) {
                    a.this.bna.a(a.this.bnb.QV().Ra());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bmZ = baseActivity;
        this.bmZ.registerListener(this.bnc);
        this.bna = new b(this.bmZ, this);
        this.bnb = new AccountSafeModel(this.bmZ);
        if (j.jE()) {
            Rb();
        } else {
            this.bmZ.showToast(d.j.neterror);
        }
    }

    public View getRootView() {
        return this.bna.getView();
    }

    private void Rb() {
        if (this.bnb != null && !this.bnb.AE()) {
            this.bnb.QY();
        }
    }

    public void onDestroy() {
        this.bmZ.closeLoadingDialog();
        if (this.bnb != null) {
            this.bnb.cancelLoadData();
        }
        if (this.bna != null) {
            this.bna.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bna != null) {
            this.bna.ey(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jE()) {
                this.bmZ.showToast(d.j.neterror);
            } else {
                ay.zK().c(this.bmZ.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.ar(this.bmZ, this.bnb != null ? this.bnb.QW() : "");
        }
    }
}
