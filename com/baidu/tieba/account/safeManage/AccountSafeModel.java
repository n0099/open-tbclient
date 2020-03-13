package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean dFH;
    private com.baidu.tieba.setting.im.more.a dYB;
    private String dYC;
    private String dYD;
    private String dYE;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aXT() {
        return this.dYB;
    }

    public String aXU() {
        return this.dYC;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dFH = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.dFH = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aXV() {
        return new PrivateInfoNetMessage();
    }

    public boolean aXW() {
        if (this.dFH) {
            return false;
        }
        this.dFH = true;
        this.mFinished = false;
        sendMessage(aXV());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dYB = aVar;
        aXX();
    }

    private void aXX() {
        SimpleUser aXY = aXY();
        if (aXY != null) {
            this.dYD = aXY.secureemail;
            this.dYE = aXY.securemobil;
            this.dYC = aXY.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aXY() {
        if (this.dYB == null || this.dYB.aXY() == null) {
            return null;
        }
        return this.dYB.aXY();
    }

    public boolean isLoading() {
        return this.dFH;
    }

    public void setLoading(boolean z) {
        this.dFH = z;
    }
}
