package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes22.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a fDg;
    private String fDh;
    private String fDi;
    private String fDj;
    private boolean fiP;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bEM() {
        return this.fDg;
    }

    public String DH() {
        return this.fDh;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fiP = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fiP = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bEN() {
        return new PrivateInfoNetMessage();
    }

    public boolean bEO() {
        if (this.fiP) {
            return false;
        }
        this.fiP = true;
        this.mFinished = false;
        sendMessage(bEN());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fDg = aVar;
        bEP();
    }

    private void bEP() {
        SimpleUser bEQ = bEQ();
        if (bEQ != null) {
            this.fDi = bEQ.secureemail;
            this.fDj = bEQ.securemobil;
            this.fDh = bEQ.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bEQ() {
        if (this.fDg == null || this.fDg.bEQ() == null) {
            return null;
        }
        return this.fDg.bEQ();
    }

    public boolean isLoading() {
        return this.fiP;
    }

    public void setLoading(boolean z) {
        this.fiP = z;
    }
}
