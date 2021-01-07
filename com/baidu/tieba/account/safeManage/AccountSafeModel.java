package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fNP;
    private com.baidu.tieba.setting.im.more.a giR;
    private String giS;
    private String giT;
    private String giU;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bOA() {
        return this.giR;
    }

    public String EA() {
        return this.giS;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fNP = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fNP = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bOB() {
        return new PrivateInfoNetMessage();
    }

    public boolean bOC() {
        if (this.fNP) {
            return false;
        }
        this.fNP = true;
        this.mFinished = false;
        sendMessage(bOB());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.giR = aVar;
        bOD();
    }

    private void bOD() {
        SimpleUser bOE = bOE();
        if (bOE != null) {
            this.giT = bOE.secureemail;
            this.giU = bOE.securemobil;
            this.giS = bOE.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bOE() {
        if (this.giR == null || this.giR.bOE() == null) {
            return null;
        }
        return this.giR.bOE();
    }

    public boolean isLoading() {
        return this.fNP;
    }

    public void setLoading(boolean z) {
        this.fNP = z;
    }
}
