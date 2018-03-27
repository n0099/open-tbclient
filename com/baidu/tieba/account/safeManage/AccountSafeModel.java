package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean bBV;
    private com.baidu.tieba.setting.im.more.a bSB;
    private String bSC;
    private String bSD;
    private String bSE;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Ut() {
        return this.bSB;
    }

    public String Uu() {
        return this.bSC;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bBV = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bBV = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Uv() {
        return new PrivateInfoNetMessage();
    }

    public boolean Uw() {
        if (this.bBV) {
            return false;
        }
        this.bBV = true;
        this.mFinished = false;
        sendMessage(Uv());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bSB = aVar;
        Ux();
    }

    private void Ux() {
        SimpleUser Uy = Uy();
        if (Uy != null) {
            this.bSD = Uy.secureemail;
            this.bSE = Uy.securemobil;
            this.bSC = Uy.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Uy() {
        if (this.bSB == null || this.bSB.Uy() == null) {
            return null;
        }
        return this.bSB.Uy();
    }

    public boolean El() {
        return this.bBV;
    }

    public void setLoading(boolean z) {
        this.bBV = z;
    }
}
