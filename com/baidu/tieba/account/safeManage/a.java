package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bcJ;
    private b bcK;
    private AccountSafeModel bcL;
    private com.baidu.adp.framework.listener.a bcM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bcL != null) {
                a.this.bcL.setLoading(false);
            }
            a.this.bcJ.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bcJ.getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bcJ.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bcL != null) {
                    a.this.bcL.a(aVar);
                }
                if (a.this.bcK != null && a.this.bcL != null && a.this.bcL.MU() != null) {
                    a.this.bcK.a(a.this.bcL.MU().MZ());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bcJ = baseActivity;
        this.bcJ.registerListener(this.bcM);
        this.bcK = new b(this.bcJ, this);
        this.bcL = new AccountSafeModel(this.bcJ);
        if (j.gP()) {
            Na();
        } else {
            this.bcJ.showToast(d.k.neterror);
        }
    }

    public View getRootView() {
        return this.bcK.getView();
    }

    private void Na() {
        if (this.bcL != null && !this.bcL.wX()) {
            this.bcL.MX();
        }
    }

    public void onDestroy() {
        this.bcJ.closeLoadingDialog();
        if (this.bcL != null) {
            this.bcL.cancelLoadData();
        }
        if (this.bcK != null) {
            this.bcK.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bcK != null) {
            this.bcK.eq(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.gP()) {
                this.bcJ.showToast(d.k.neterror);
            } else {
                ax.wg().c(this.bcJ.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view2.getId() == d.g.account_status) {
            AntiHelper.an(this.bcJ, this.bcL != null ? this.bcL.MV() : "");
        }
    }
}
