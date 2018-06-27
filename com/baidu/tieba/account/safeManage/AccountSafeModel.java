package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aVp;
    private com.baidu.tieba.setting.im.more.a bmp;
    private String bmq;
    private String bmr;
    private String bms;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a QO() {
        return this.bmp;
    }

    public String QP() {
        return this.bmq;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aVp = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aVp = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage QQ() {
        return new PrivateInfoNetMessage();
    }

    public boolean QR() {
        if (this.aVp) {
            return false;
        }
        this.aVp = true;
        this.mFinished = false;
        sendMessage(QQ());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bmp = aVar;
        QS();
    }

    private void QS() {
        SimpleUser QT = QT();
        if (QT != null) {
            this.bmr = QT.secureemail;
            this.bms = QT.securemobil;
            this.bmq = QT.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser QT() {
        if (this.bmp == null || this.bmp.QT() == null) {
            return null;
        }
        return this.bmp.QT();
    }

    public boolean AO() {
        return this.aVp;
    }

    public void setLoading(boolean z) {
        this.aVp = z;
    }
}
