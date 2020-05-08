package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean efJ;
    private com.baidu.tieba.setting.im.more.a eyT;
    private String eyU;
    private String eyV;
    private String eyW;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bga() {
        return this.eyT;
    }

    public String bgb() {
        return this.eyU;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.efJ = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.efJ = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bgc() {
        return new PrivateInfoNetMessage();
    }

    public boolean bgd() {
        if (this.efJ) {
            return false;
        }
        this.efJ = true;
        this.mFinished = false;
        sendMessage(bgc());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.eyT = aVar;
        bge();
    }

    private void bge() {
        SimpleUser bgf = bgf();
        if (bgf != null) {
            this.eyV = bgf.secureemail;
            this.eyW = bgf.securemobil;
            this.eyU = bgf.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bgf() {
        if (this.eyT == null || this.eyT.bgf() == null) {
            return null;
        }
        return this.eyT.bgf();
    }

    public boolean isLoading() {
        return this.efJ;
    }

    public void setLoading(boolean z) {
        this.efJ = z;
    }
}
