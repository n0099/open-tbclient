package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cAm;
    private com.baidu.tieba.setting.im.more.a cVm;
    private String cVn;
    private String cVo;
    private String cVp;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aBD() {
        return this.cVm;
    }

    public String aBE() {
        return this.cVn;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cAm = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cAm = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aBF() {
        return new PrivateInfoNetMessage();
    }

    public boolean aBG() {
        if (this.cAm) {
            return false;
        }
        this.cAm = true;
        this.mFinished = false;
        sendMessage(aBF());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cVm = aVar;
        aBH();
    }

    private void aBH() {
        SimpleUser aBI = aBI();
        if (aBI != null) {
            this.cVo = aBI.secureemail;
            this.cVp = aBI.securemobil;
            this.cVn = aBI.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aBI() {
        if (this.cVm == null || this.cVm.aBI() == null) {
            return null;
        }
        return this.cVm.aBI();
    }

    public boolean pu() {
        return this.cAm;
    }

    public void setLoading(boolean z) {
        this.cAm = z;
    }
}
