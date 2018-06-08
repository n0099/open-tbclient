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
    private final BaseActivity bkU;
    private b bkV;
    private AccountSafeModel bkW;
    private com.baidu.adp.framework.listener.a bkX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bkW != null) {
                a.this.bkW.setLoading(false);
            }
            a.this.bkU.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bkU.getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bkU.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bkW != null) {
                    a.this.bkW.a(aVar);
                }
                if (a.this.bkV != null && a.this.bkW != null && a.this.bkW.Qr() != null) {
                    a.this.bkV.a(a.this.bkW.Qr().Qw());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bkU = baseActivity;
        this.bkU.registerListener(this.bkX);
        this.bkV = new b(this.bkU, this);
        this.bkW = new AccountSafeModel(this.bkU);
        if (j.jD()) {
            Qx();
        } else {
            this.bkU.showToast(d.k.neterror);
        }
    }

    public View getRootView() {
        return this.bkV.getView();
    }

    private void Qx() {
        if (this.bkW != null && !this.bkW.Ax()) {
            this.bkW.Qu();
        }
    }

    public void onDestroy() {
        this.bkU.closeLoadingDialog();
        if (this.bkW != null) {
            this.bkW.cancelLoadData();
        }
        if (this.bkV != null) {
            this.bkV.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bkV != null) {
            this.bkV.eu(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jD()) {
                this.bkU.showToast(d.k.neterror);
            } else {
                ay.zG().c(this.bkU.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.ap(this.bkU, this.bkW != null ? this.bkW.Qs() : "");
        }
    }
}
