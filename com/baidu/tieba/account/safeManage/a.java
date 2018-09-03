package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.f;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bnc;
    private b bnd;
    private AccountSafeModel bne;
    private com.baidu.adp.framework.listener.a bnf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bne != null) {
                a.this.bne.setLoading(false);
            }
            a.this.bnc.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bnc.getString(f.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bnc.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bne != null) {
                    a.this.bne.a(aVar);
                }
                if (a.this.bnd != null && a.this.bne != null && a.this.bne.Ra() != null) {
                    a.this.bnd.a(a.this.bne.Ra().Rf());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bnc = baseActivity;
        this.bnc.registerListener(this.bnf);
        this.bnd = new b(this.bnc, this);
        this.bne = new AccountSafeModel(this.bnc);
        if (j.jE()) {
            Rg();
        } else {
            this.bnc.showToast(f.j.neterror);
        }
    }

    public View getRootView() {
        return this.bnd.getView();
    }

    private void Rg() {
        if (this.bne != null && !this.bne.AB()) {
            this.bne.Rd();
        }
    }

    public void onDestroy() {
        this.bnc.closeLoadingDialog();
        if (this.bne != null) {
            this.bne.cancelLoadData();
        }
        if (this.bnd != null) {
            this.bnd.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bnd != null) {
            this.bnd.ex(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jE()) {
                this.bnc.showToast(f.j.neterror);
            } else {
                az.zI().c(this.bnc.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == f.g.account_status) {
            AntiHelper.ar(this.bnc, this.bne != null ? this.bne.Rb() : "");
        }
    }
}
