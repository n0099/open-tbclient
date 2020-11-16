package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes21.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a fQZ;
    private String fRa;
    private String fRb;
    private String fRc;
    private boolean fwv;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bIy() {
        return this.fQZ;
    }

    public String Dz() {
        return this.fRa;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fwv = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fwv = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bIz() {
        return new PrivateInfoNetMessage();
    }

    public boolean bIA() {
        if (this.fwv) {
            return false;
        }
        this.fwv = true;
        this.mFinished = false;
        sendMessage(bIz());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fQZ = aVar;
        bIB();
    }

    private void bIB() {
        SimpleUser bIC = bIC();
        if (bIC != null) {
            this.fRb = bIC.secureemail;
            this.fRc = bIC.securemobil;
            this.fRa = bIC.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bIC() {
        if (this.fQZ == null || this.fQZ.bIC() == null) {
            return null;
        }
        return this.fQZ.bIC();
    }

    public boolean isLoading() {
        return this.fwv;
    }

    public void setLoading(boolean z) {
        this.fwv = z;
    }
}
