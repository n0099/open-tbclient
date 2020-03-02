package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean dFu;
    private com.baidu.tieba.setting.im.more.a dYo;
    private String dYp;
    private String dYq;
    private String dYr;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aXS() {
        return this.dYo;
    }

    public String aXT() {
        return this.dYp;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dFu = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.dFu = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aXU() {
        return new PrivateInfoNetMessage();
    }

    public boolean aXV() {
        if (this.dFu) {
            return false;
        }
        this.dFu = true;
        this.mFinished = false;
        sendMessage(aXU());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dYo = aVar;
        aXW();
    }

    private void aXW() {
        SimpleUser aXX = aXX();
        if (aXX != null) {
            this.dYq = aXX.secureemail;
            this.dYr = aXX.securemobil;
            this.dYp = aXX.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aXX() {
        if (this.dYo == null || this.dYo.aXX() == null) {
            return null;
        }
        return this.dYo.aXX();
    }

    public boolean isLoading() {
        return this.dFu;
    }

    public void setLoading(boolean z) {
        this.dFu = z;
    }
}
