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
    private final BaseActivity bxI;
    private b bxJ;
    private AccountSafeModel bxK;
    private com.baidu.adp.framework.listener.a bxL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bxK != null) {
                a.this.bxK.setLoading(false);
            }
            a.this.bxI.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bxI.getString(e.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bxI.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bxK != null) {
                    a.this.bxK.a(aVar);
                }
                if (a.this.bxJ != null && a.this.bxK != null && a.this.bxK.UT() != null) {
                    a.this.bxJ.a(a.this.bxK.UT().UY());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bxI = baseActivity;
        this.bxI.registerListener(this.bxL);
        this.bxJ = new b(this.bxI, this);
        this.bxK = new AccountSafeModel(this.bxI);
        if (j.kV()) {
            UZ();
        } else {
            this.bxI.showToast(e.j.neterror);
        }
    }

    public View getRootView() {
        return this.bxJ.getView();
    }

    private void UZ() {
        if (this.bxK != null && !this.bxK.Ee()) {
            this.bxK.UW();
        }
    }

    public void onDestroy() {
        this.bxI.closeLoadingDialog();
        if (this.bxK != null) {
            this.bxK.cancelLoadData();
        }
        if (this.bxJ != null) {
            this.bxJ.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bxJ != null) {
            this.bxJ.fg(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.kV()) {
                this.bxI.showToast(e.j.neterror);
            } else {
                ay.Db().c(this.bxI.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == e.g.account_status) {
            AntiHelper.aH(this.bxI, this.bxK != null ? this.bxK.UU() : "");
        }
    }
}
