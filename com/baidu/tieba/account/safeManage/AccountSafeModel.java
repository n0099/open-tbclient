package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes21.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean eWD;
    private com.baidu.tieba.setting.im.more.a fqT;
    private String fqU;
    private String fqV;
    private String fqW;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bCa() {
        return this.fqT;
    }

    public String CK() {
        return this.fqU;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eWD = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.eWD = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bCb() {
        return new PrivateInfoNetMessage();
    }

    public boolean bCc() {
        if (this.eWD) {
            return false;
        }
        this.eWD = true;
        this.mFinished = false;
        sendMessage(bCb());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fqT = aVar;
        bCd();
    }

    private void bCd() {
        SimpleUser bCe = bCe();
        if (bCe != null) {
            this.fqV = bCe.secureemail;
            this.fqW = bCe.securemobil;
            this.fqU = bCe.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bCe() {
        if (this.fqT == null || this.fqT.bCe() == null) {
            return null;
        }
        return this.fqT.bCe();
    }

    public boolean isLoading() {
        return this.eWD;
    }

    public void setLoading(boolean z) {
        this.eWD = z;
    }
}
