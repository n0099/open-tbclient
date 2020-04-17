package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean efE;
    private com.baidu.tieba.setting.im.more.a eyO;
    private String eyP;
    private String eyQ;
    private String eyR;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bgc() {
        return this.eyO;
    }

    public String bgd() {
        return this.eyP;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.efE = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.efE = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bge() {
        return new PrivateInfoNetMessage();
    }

    public boolean bgf() {
        if (this.efE) {
            return false;
        }
        this.efE = true;
        this.mFinished = false;
        sendMessage(bge());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.eyO = aVar;
        bgg();
    }

    private void bgg() {
        SimpleUser bgh = bgh();
        if (bgh != null) {
            this.eyQ = bgh.secureemail;
            this.eyR = bgh.securemobil;
            this.eyP = bgh.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bgh() {
        if (this.eyO == null || this.eyO.bgh() == null) {
            return null;
        }
        return this.eyO.bgh();
    }

    public boolean isLoading() {
        return this.efE;
    }

    public void setLoading(boolean z) {
        this.efE = z;
    }
}
