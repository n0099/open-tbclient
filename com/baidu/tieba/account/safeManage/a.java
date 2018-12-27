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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bBi;
    private b bBj;
    private AccountSafeModel bBk;
    private com.baidu.adp.framework.listener.a bBl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bBk != null) {
                a.this.bBk.setLoading(false);
            }
            a.this.bBi.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bBi.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bBi.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bBk != null) {
                    a.this.bBk.a(aVar);
                }
                if (a.this.bBj != null && a.this.bBk != null && a.this.bBk.Wb() != null) {
                    a.this.bBj.a(a.this.bBk.Wb().Wg());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bBi = baseActivity;
        this.bBi.registerListener(this.bBl);
        this.bBj = new b(this.bBi, this);
        this.bBk = new AccountSafeModel(this.bBi);
        if (j.kV()) {
            Wh();
        } else {
            this.bBi.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bBj.getView();
    }

    private void Wh() {
        if (this.bBk != null && !this.bBk.Fi()) {
            this.bBk.We();
        }
    }

    public void onDestroy() {
        this.bBi.closeLoadingDialog();
        if (this.bBk != null) {
            this.bBk.cancelLoadData();
        }
        if (this.bBj != null) {
            this.bBj.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bBj != null) {
            this.bBj.fv(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kV()) {
                this.bBi.showToast(e.j.neterror);
            } else {
                ay.Ef().c(this.bBi.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aK(this.bBi, this.bBk != null ? this.bBk.Wc() : "");
        }
    }
}
