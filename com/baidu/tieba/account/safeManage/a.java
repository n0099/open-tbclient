package com.baidu.tieba.account.safeManage;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private final BaseActivity bmt;
    private b bmu;
    private AccountSafeModel bmv;
    private com.baidu.adp.framework.listener.a bmw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.account.safeManage.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            if (a.this.bmv != null) {
                a.this.bmv.setLoading(false);
            }
            a.this.bmt.closeLoadingDialog();
            if (responsedMessage != null) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        errorString = a.this.bmt.getString(d.k.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    a.this.bmt.showToast(errorString);
                    return;
                }
                com.baidu.tieba.setting.im.more.a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (a.this.bmv != null) {
                    a.this.bmv.a(aVar);
                }
                if (a.this.bmu != null && a.this.bmv != null && a.this.bmv.QO() != null) {
                    a.this.bmu.a(a.this.bmv.QO().QT());
                }
            }
        }
    };

    public a(BaseActivity baseActivity) {
        this.bmt = baseActivity;
        this.bmt.registerListener(this.bmw);
        this.bmu = new b(this.bmt, this);
        this.bmv = new AccountSafeModel(this.bmt);
        if (j.jD()) {
            QU();
        } else {
            this.bmt.showToast(d.k.neterror);
        }
    }

    public View getRootView() {
        return this.bmu.getView();
    }

    private void QU() {
        if (this.bmv != null && !this.bmv.AO()) {
            this.bmv.QR();
        }
    }

    public void onDestroy() {
        this.bmt.closeLoadingDialog();
        if (this.bmv != null) {
            this.bmv.cancelLoadData();
        }
        if (this.bmu != null) {
            this.bmu.release();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bmu != null) {
            this.bmu.ev(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.bar_record) {
            TiebaStatic.log("c10013");
            if (!j.jD()) {
                this.bmt.showToast(d.k.neterror);
            } else {
                az.zV().c(this.bmt.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/accountSecurity/accountOption"});
            }
        } else if (view.getId() == d.g.account_status) {
            AntiHelper.ap(this.bmt, this.bmv != null ? this.bmv.QP() : "");
        }
    }
}
