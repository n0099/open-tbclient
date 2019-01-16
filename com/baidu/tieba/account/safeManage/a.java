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
    private final BaseActivity bBV;
    private b bBW;
    private AccountSafeModel bBX;
    private com.baidu.adp.framework.listener.a bBY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bBX != null) {
                a.this.bBX.setLoading(false);
            }
            a.this.bBV.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bBV.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bBV.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bBX != null) {
                    a.this.bBX.a(aVar);
                }
                if (a.this.bBW != null && a.this.bBX != null && a.this.bBX.Wx() != null) {
                    a.this.bBW.a(a.this.bBX.Wx().WC());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bBV = baseActivity;
        this.bBV.registerListener(this.bBY);
        this.bBW = new b(this.bBV, this);
        this.bBX = new AccountSafeModel(this.bBV);
        if (j.kV()) {
            WD();
        } else {
            this.bBV.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bBW.getView();
    }

    private void WD() {
        if (this.bBX != null && !this.bBX.Fv()) {
            this.bBX.WA();
        }
    }

    public void onDestroy() {
        this.bBV.closeLoadingDialog();
        if (this.bBX != null) {
            this.bBX.cancelLoadData();
        }
        if (this.bBW != null) {
            this.bBW.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bBW != null) {
            this.bBW.fv(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kV()) {
                this.bBV.showToast(e.j.neterror);
            } else {
                ay.Es().c(this.bBV.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aI(this.bBV, this.bBX != null ? this.bBX.Wy() : "");
        }
    }
}
