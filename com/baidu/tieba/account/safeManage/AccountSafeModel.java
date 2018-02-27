package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean bBS;
    private String bSA;
    private String bSB;
    private com.baidu.tieba.setting.im.more.a bSy;
    private String bSz;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Us() {
        return this.bSy;
    }

    public String Ut() {
        return this.bSz;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bBS = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bBS = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Uu() {
        return new PrivateInfoNetMessage();
    }

    public boolean Uv() {
        if (this.bBS) {
            return false;
        }
        this.bBS = true;
        this.mFinished = false;
        sendMessage(Uu());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bSy = aVar;
        Uw();
    }

    private void Uw() {
        SimpleUser Ux = Ux();
        if (Ux != null) {
            this.bSA = Ux.secureemail;
            this.bSB = Ux.securemobil;
            this.bSz = Ux.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Ux() {
        if (this.bSy == null || this.bSy.Ux() == null) {
            return null;
        }
        return this.bSy.Ux();
    }

    public boolean Ek() {
        return this.bBS;
    }

    public void setLoading(boolean z) {
        this.bBS = z;
    }
}
