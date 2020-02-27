package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean dFt;
    private com.baidu.tieba.setting.im.more.a dYn;
    private String dYo;
    private String dYp;
    private String dYq;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aXQ() {
        return this.dYn;
    }

    public String aXR() {
        return this.dYo;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dFt = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.dFt = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aXS() {
        return new PrivateInfoNetMessage();
    }

    public boolean aXT() {
        if (this.dFt) {
            return false;
        }
        this.dFt = true;
        this.mFinished = false;
        sendMessage(aXS());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dYn = aVar;
        aXU();
    }

    private void aXU() {
        SimpleUser aXV = aXV();
        if (aXV != null) {
            this.dYp = aXV.secureemail;
            this.dYq = aXV.securemobil;
            this.dYo = aXV.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aXV() {
        if (this.dYn == null || this.dYn.aXV() == null) {
            return null;
        }
        return this.dYn.aXV();
    }

    public boolean isLoading() {
        return this.dFt;
    }

    public void setLoading(boolean z) {
        this.dFt = z;
    }
}
