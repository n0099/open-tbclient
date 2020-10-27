package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes22.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a fLB;
    private String fLC;
    private String fLD;
    private String fLE;
    private boolean frn;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bGF() {
        return this.fLB;
    }

    public String DP() {
        return this.fLC;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.frn = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.frn = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bGG() {
        return new PrivateInfoNetMessage();
    }

    public boolean bGH() {
        if (this.frn) {
            return false;
        }
        this.frn = true;
        this.mFinished = false;
        sendMessage(bGG());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fLB = aVar;
        bGI();
    }

    private void bGI() {
        SimpleUser bGJ = bGJ();
        if (bGJ != null) {
            this.fLD = bGJ.secureemail;
            this.fLE = bGJ.securemobil;
            this.fLC = bGJ.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bGJ() {
        if (this.fLB == null || this.fLB.bGJ() == null) {
            return null;
        }
        return this.fLB.bGJ();
    }

    public boolean isLoading() {
        return this.frn;
    }

    public void setLoading(boolean z) {
        this.frn = z;
    }
}
