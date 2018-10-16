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
    private final BaseActivity bwX;
    private b bwY;
    private AccountSafeModel bwZ;
    private com.baidu.adp.framework.listener.a bxa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bwZ != null) {
                a.this.bwZ.setLoading(false);
            }
            a.this.bwX.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bwX.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bwX.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bwZ != null) {
                    a.this.bwZ.a(aVar);
                }
                if (a.this.bwY != null && a.this.bwZ != null && a.this.bwZ.UK() != null) {
                    a.this.bwY.a(a.this.bwZ.UK().UP());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bwX = baseActivity;
        this.bwX.registerListener(this.bxa);
        this.bwY = new b(this.bwX, this);
        this.bwZ = new AccountSafeModel(this.bwX);
        if (j.kX()) {
            UQ();
        } else {
            this.bwX.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bwY.getView();
    }

    private void UQ() {
        if (this.bwZ != null && !this.bwZ.DU()) {
            this.bwZ.UN();
        }
    }

    public void onDestroy() {
        this.bwX.closeLoadingDialog();
        if (this.bwZ != null) {
            this.bwZ.cancelLoadData();
        }
        if (this.bwY != null) {
            this.bwY.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bwY != null) {
            this.bwY.eS(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kX()) {
                this.bwX.showToast(e.j.neterror);
            } else {
                ay.CU().c(this.bwX.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aJ(this.bwX, this.bwZ != null ? this.bwZ.UL() : "");
        }
    }
}
