package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean dBi;
    private com.baidu.tieba.setting.im.more.a dUa;
    private String dUb;
    private String dUc;
    private String dUd;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aVi() {
        return this.dUa;
    }

    public String aVj() {
        return this.dUb;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dBi = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.dBi = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aVk() {
        return new PrivateInfoNetMessage();
    }

    public boolean aVl() {
        if (this.dBi) {
            return false;
        }
        this.dBi = true;
        this.mFinished = false;
        sendMessage(aVk());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dUa = aVar;
        aVm();
    }

    private void aVm() {
        SimpleUser aVn = aVn();
        if (aVn != null) {
            this.dUc = aVn.secureemail;
            this.dUd = aVn.securemobil;
            this.dUb = aVn.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aVn() {
        if (this.dUa == null || this.dUa.aVn() == null) {
            return null;
        }
        return this.dUa.aVn();
    }

    public boolean isLoading() {
        return this.dBi;
    }

    public void setLoading(boolean z) {
        this.dBi = z;
    }
}
