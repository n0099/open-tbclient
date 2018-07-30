package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aVq;
    private com.baidu.tieba.setting.im.more.a bmV;
    private String bmW;
    private String bmX;
    private String bmY;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a QV() {
        return this.bmV;
    }

    public String QW() {
        return this.bmW;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aVq = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aVq = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage QX() {
        return new PrivateInfoNetMessage();
    }

    public boolean QY() {
        if (this.aVq) {
            return false;
        }
        this.aVq = true;
        this.mFinished = false;
        sendMessage(QX());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bmV = aVar;
        QZ();
    }

    private void QZ() {
        SimpleUser Ra = Ra();
        if (Ra != null) {
            this.bmX = Ra.secureemail;
            this.bmY = Ra.securemobil;
            this.bmW = Ra.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Ra() {
        if (this.bmV == null || this.bmV.Ra() == null) {
            return null;
        }
        return this.bmV.Ra();
    }

    public boolean AE() {
        return this.aVq;
    }

    public void setLoading(boolean z) {
        this.aVq = z;
    }
}
