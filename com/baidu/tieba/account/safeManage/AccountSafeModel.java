package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cAl;
    private com.baidu.tieba.setting.im.more.a cVl;
    private String cVm;
    private String cVn;
    private String cVo;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aBD() {
        return this.cVl;
    }

    public String aBE() {
        return this.cVm;
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

    private PrivateInfoNetMessage aBF() {
        return new PrivateInfoNetMessage();
    }

    public boolean aBG() {
        if (this.cAl) {
            return false;
        }
        this.cAl = true;
        this.mFinished = false;
        sendMessage(aBF());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cVl = aVar;
        aBH();
    }

    private void aBH() {
        SimpleUser aBI = aBI();
        if (aBI != null) {
            this.cVn = aBI.secureemail;
            this.cVo = aBI.securemobil;
            this.cVm = aBI.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aBI() {
        if (this.cVl == null || this.cVl.aBI() == null) {
            return null;
        }
        return this.cVl.aBI();
    }

    public boolean pu() {
        return this.cAl;
    }

    public void setLoading(boolean z) {
        this.cAl = z;
    }
}
