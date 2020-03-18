package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean dFX;
    private com.baidu.tieba.setting.im.more.a dYR;
    private String dYS;
    private String dYT;
    private String dYU;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aXX() {
        return this.dYR;
    }

    public String aXY() {
        return this.dYS;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dFX = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.dFX = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aXZ() {
        return new PrivateInfoNetMessage();
    }

    public boolean aYa() {
        if (this.dFX) {
            return false;
        }
        this.dFX = true;
        this.mFinished = false;
        sendMessage(aXZ());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dYR = aVar;
        aYb();
    }

    private void aYb() {
        SimpleUser aYc = aYc();
        if (aYc != null) {
            this.dYT = aYc.secureemail;
            this.dYU = aYc.securemobil;
            this.dYS = aYc.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aYc() {
        if (this.dYR == null || this.dYR.aYc() == null) {
            return null;
        }
        return this.dYR.aYc();
    }

    public boolean isLoading() {
        return this.dFX;
    }

    public void setLoading(boolean z) {
        this.dFX = z;
    }
}
