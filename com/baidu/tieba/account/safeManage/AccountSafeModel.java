package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes7.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean dBs;
    private com.baidu.tieba.setting.im.more.a dUj;
    private String dUk;
    private String dUl;
    private String dUm;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aVB() {
        return this.dUj;
    }

    public String aVC() {
        return this.dUk;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dBs = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.dBs = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aVD() {
        return new PrivateInfoNetMessage();
    }

    public boolean aVE() {
        if (this.dBs) {
            return false;
        }
        this.dBs = true;
        this.mFinished = false;
        sendMessage(aVD());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dUj = aVar;
        aVF();
    }

    private void aVF() {
        SimpleUser aVG = aVG();
        if (aVG != null) {
            this.dUl = aVG.secureemail;
            this.dUm = aVG.securemobil;
            this.dUk = aVG.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aVG() {
        if (this.dUj == null || this.dUj.aVG() == null) {
            return null;
        }
        return this.dUj.aVG();
    }

    public boolean isLoading() {
        return this.dBs;
    }

    public void setLoading(boolean z) {
        this.dBs = z;
    }
}
