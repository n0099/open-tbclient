package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cAl;
    private com.baidu.tieba.setting.im.more.a cVk;
    private String cVl;
    private String cVm;
    private String cVn;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aBA() {
        return this.cVk;
    }

    public String aBB() {
        return this.cVl;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cAl = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cAl = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aBC() {
        return new PrivateInfoNetMessage();
    }

    public boolean aBD() {
        if (this.cAl) {
            return false;
        }
        this.cAl = true;
        this.mFinished = false;
        sendMessage(aBC());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cVk = aVar;
        aBE();
    }

    private void aBE() {
        SimpleUser aBF = aBF();
        if (aBF != null) {
            this.cVm = aBF.secureemail;
            this.cVn = aBF.securemobil;
            this.cVl = aBF.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aBF() {
        if (this.cVk == null || this.cVk.aBF() == null) {
            return null;
        }
        return this.cVk.aBF();
    }

    public boolean pu() {
        return this.cAl;
    }

    public void setLoading(boolean z) {
        this.cAl = z;
    }
}
