package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cBD;
    private com.baidu.tieba.setting.im.more.a cWI;
    private String cWJ;
    private String cWK;
    private String cWL;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aCS() {
        return this.cWI;
    }

    public String aCT() {
        return this.cWJ;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cBD = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cBD = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aCU() {
        return new PrivateInfoNetMessage();
    }

    public boolean aCV() {
        if (this.cBD) {
            return false;
        }
        this.cBD = true;
        this.mFinished = false;
        sendMessage(aCU());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cWI = aVar;
        aCW();
    }

    private void aCW() {
        SimpleUser aCX = aCX();
        if (aCX != null) {
            this.cWK = aCX.secureemail;
            this.cWL = aCX.securemobil;
            this.cWJ = aCX.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aCX() {
        if (this.cWI == null || this.cWI.aCX() == null) {
            return null;
        }
        return this.cWI.aCX();
    }

    public boolean pP() {
        return this.cBD;
    }

    public void setLoading(boolean z) {
        this.cBD = z;
    }
}
