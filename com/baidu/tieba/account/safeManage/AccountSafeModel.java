package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cCG;
    private com.baidu.tieba.setting.im.more.a cXI;
    private String cXJ;
    private String cXK;
    private String cXL;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aDi() {
        return this.cXI;
    }

    public String aDj() {
        return this.cXJ;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cCG = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cCG = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aDk() {
        return new PrivateInfoNetMessage();
    }

    public boolean aDl() {
        if (this.cCG) {
            return false;
        }
        this.cCG = true;
        this.mFinished = false;
        sendMessage(aDk());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cXI = aVar;
        aDm();
    }

    private void aDm() {
        SimpleUser aDn = aDn();
        if (aDn != null) {
            this.cXK = aDn.secureemail;
            this.cXL = aDn.securemobil;
            this.cXJ = aDn.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aDn() {
        if (this.cXI == null || this.cXI.aDn() == null) {
            return null;
        }
        return this.cXI.aDn();
    }

    public boolean pQ() {
        return this.cCG;
    }

    public void setLoading(boolean z) {
        this.cCG = z;
    }
}
