package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean bCf;
    private com.baidu.tieba.setting.im.more.a bSK;
    private String bSL;
    private String bSM;
    private String bSN;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Ut() {
        return this.bSK;
    }

    public String Uu() {
        return this.bSL;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bCf = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bCf = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Uv() {
        return new PrivateInfoNetMessage();
    }

    public boolean Uw() {
        if (this.bCf) {
            return false;
        }
        this.bCf = true;
        this.mFinished = false;
        sendMessage(Uv());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bSK = aVar;
        Ux();
    }

    private void Ux() {
        SimpleUser Uy = Uy();
        if (Uy != null) {
            this.bSM = Uy.secureemail;
            this.bSN = Uy.securemobil;
            this.bSL = Uy.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Uy() {
        if (this.bSK == null || this.bSK.Uy() == null) {
            return null;
        }
        return this.bSK.Uy();
    }

    public boolean El() {
        return this.bCf;
    }

    public void setLoading(boolean z) {
        this.bCf = z;
    }
}
