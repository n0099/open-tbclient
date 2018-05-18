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
    private final BaseActivity bcK;
    private b bcL;
    private AccountSafeModel bcM;
    private com.baidu.adp.framework.listener.a bcN = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bcM != null) {
                a.this.bcM.setLoading(false);
            }
            a.this.bcK.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bcK.getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bcK.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bcM != null) {
                    a.this.bcM.a(aVar);
                }
                if (a.this.bcL != null && a.this.bcM != null && a.this.bcM.MS() != null) {
                    a.this.bcL.a(a.this.bcM.MS().MX());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bcK = baseActivity;
        this.bcK.registerListener(this.bcN);
        this.bcL = new b(this.bcK, this);
        this.bcM = new AccountSafeModel(this.bcK);
        if (j.gP()) {
            MY();
        } else {
            this.bcK.showToast(d.k.neterror);
        }
    }

    public View getRootView() {
        return this.bcL.getView();
    }

    private void MY() {
        if (this.bcM != null && !this.bcM.wW()) {
            this.bcM.MV();
        }
    }

    public void onDestroy() {
        this.bcK.closeLoadingDialog();
        if (this.bcM != null) {
            this.bcM.cancelLoadData();
        }
        if (this.bcL != null) {
            this.bcL.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bcL != null) {
            this.bcL.eq(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.gP()) {
                this.bcK.showToast(d.k.neterror);
            } else {
                ax.wf().c(this.bcK.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view2.getId() == d.g.account_status) {
            AntiHelper.an(this.bcK, this.bcM != null ? this.bcM.MT() : "");
        }
    }
}
