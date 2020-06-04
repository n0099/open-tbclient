package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a eNE;
    private String eNF;
    private String eNG;
    private String eNH;
    private boolean etX;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bmo() {
        return this.eNE;
    }

    public String vX() {
        return this.eNF;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.etX = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.etX = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bmp() {
        return new PrivateInfoNetMessage();
    }

    public boolean bmq() {
        if (this.etX) {
            return false;
        }
        this.etX = true;
        this.mFinished = false;
        sendMessage(bmp());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.eNE = aVar;
        bmr();
    }

    private void bmr() {
        SimpleUser bms = bms();
        if (bms != null) {
            this.eNG = bms.secureemail;
            this.eNH = bms.securemobil;
            this.eNF = bms.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bms() {
        if (this.eNE == null || this.eNE.bms() == null) {
            return null;
        }
        return this.eNE.bms();
    }

    public boolean isLoading() {
        return this.etX;
    }

    public void setLoading(boolean z) {
        this.etX = z;
    }
}
