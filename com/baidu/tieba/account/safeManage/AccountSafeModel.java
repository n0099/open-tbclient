package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a bBS;
    private String bBT;
    private String bBU;
    private String bBV;
    private boolean bij;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Wx() {
        return this.bBS;
    }

    public String Wy() {
        return this.bBT;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bij = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bij = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Wz() {
        return new PrivateInfoNetMessage();
    }

    public boolean WA() {
        if (this.bij) {
            return false;
        }
        this.bij = true;
        this.mFinished = false;
        sendMessage(Wz());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bBS = aVar;
        WB();
    }

    private void WB() {
        SimpleUser WC = WC();
        if (WC != null) {
            this.bBU = WC.secureemail;
            this.bBV = WC.securemobil;
            this.bBT = WC.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser WC() {
        if (this.bBS == null || this.bBS.WC() == null) {
            return null;
        }
        return this.bBS.WC();
    }

    public boolean Fv() {
        return this.bij;
    }

    public void setLoading(boolean z) {
        this.bij = z;
    }
}
