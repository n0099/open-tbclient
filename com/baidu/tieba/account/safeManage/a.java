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
    private final BaseActivity bBW;
    private b bBX;
    private AccountSafeModel bBY;
    private com.baidu.adp.framework.listener.a bBZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bBY != null) {
                a.this.bBY.setLoading(false);
            }
            a.this.bBW.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bBW.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bBW.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bBY != null) {
                    a.this.bBY.a(aVar);
                }
                if (a.this.bBX != null && a.this.bBY != null && a.this.bBY.Wx() != null) {
                    a.this.bBX.a(a.this.bBY.Wx().WC());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bBW = baseActivity;
        this.bBW.registerListener(this.bBZ);
        this.bBX = new b(this.bBW, this);
        this.bBY = new AccountSafeModel(this.bBW);
        if (j.kV()) {
            WD();
        } else {
            this.bBW.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bBX.getView();
    }

    private void WD() {
        if (this.bBY != null && !this.bBY.Fv()) {
            this.bBY.WA();
        }
    }

    public void onDestroy() {
        this.bBW.closeLoadingDialog();
        if (this.bBY != null) {
            this.bBY.cancelLoadData();
        }
        if (this.bBX != null) {
            this.bBX.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bBX != null) {
            this.bBX.fv(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kV()) {
                this.bBW.showToast(e.j.neterror);
            } else {
                ay.Es().c(this.bBW.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aI(this.bBW, this.bBY != null ? this.bBY.Wy() : "");
        }
    }
}
