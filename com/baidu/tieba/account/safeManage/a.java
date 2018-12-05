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
    private final BaseActivity bBf;
    private b bBg;
    private AccountSafeModel bBh;
    private com.baidu.adp.framework.listener.a bBi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bBh != null) {
                a.this.bBh.setLoading(false);
            }
            a.this.bBf.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bBf.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bBf.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bBh != null) {
                    a.this.bBh.a(aVar);
                }
                if (a.this.bBg != null && a.this.bBh != null && a.this.bBh.VZ() != null) {
                    a.this.bBg.a(a.this.bBh.VZ().We());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bBf = baseActivity;
        this.bBf.registerListener(this.bBi);
        this.bBg = new b(this.bBf, this);
        this.bBh = new AccountSafeModel(this.bBf);
        if (j.kV()) {
            Wf();
        } else {
            this.bBf.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bBg.getView();
    }

    private void Wf() {
        if (this.bBh != null && !this.bBh.Fi()) {
            this.bBh.Wc();
        }
    }

    public void onDestroy() {
        this.bBf.closeLoadingDialog();
        if (this.bBh != null) {
            this.bBh.cancelLoadData();
        }
        if (this.bBg != null) {
            this.bBg.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bBg != null) {
            this.bBg.fu(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kV()) {
                this.bBf.showToast(e.j.neterror);
            } else {
                ay.Ef().c(this.bBf.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aK(this.bBf, this.bBh != null ? this.bBh.Wa() : "");
        }
    }
}
