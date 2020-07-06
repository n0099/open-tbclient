package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean eCO;
    private com.baidu.tieba.setting.im.more.a eXP;
    private String eXQ;
    private String eXR;
    private String eXS;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a boO() {
        return this.eXP;
    }

    public String wv() {
        return this.eXQ;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eCO = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.eCO = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage boP() {
        return new PrivateInfoNetMessage();
    }

    public boolean boQ() {
        if (this.eCO) {
            return false;
        }
        this.eCO = true;
        this.mFinished = false;
        sendMessage(boP());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.eXP = aVar;
        boR();
    }

    private void boR() {
        SimpleUser boS = boS();
        if (boS != null) {
            this.eXR = boS.secureemail;
            this.eXS = boS.securemobil;
            this.eXQ = boS.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser boS() {
        if (this.eXP == null || this.eXP.boS() == null) {
            return null;
        }
        return this.eXP.boS();
    }

    public boolean isLoading() {
        return this.eCO;
    }

    public void setLoading(boolean z) {
        this.eCO = z;
    }
}
