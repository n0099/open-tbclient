package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes22.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fEk;
    private com.baidu.tieba.setting.im.more.a fZk;
    private String fZl;
    private String fZm;
    private String fZn;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bMh() {
        return this.fZk;
    }

    public String Fk() {
        return this.fZl;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fEk = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fEk = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bMi() {
        return new PrivateInfoNetMessage();
    }

    public boolean bMj() {
        if (this.fEk) {
            return false;
        }
        this.fEk = true;
        this.mFinished = false;
        sendMessage(bMi());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fZk = aVar;
        bMk();
    }

    private void bMk() {
        SimpleUser bMl = bMl();
        if (bMl != null) {
            this.fZm = bMl.secureemail;
            this.fZn = bMl.securemobil;
            this.fZl = bMl.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bMl() {
        if (this.fZk == null || this.fZk.bMl() == null) {
            return null;
        }
        return this.fZk.bMl();
    }

    public boolean isLoading() {
        return this.fEk;
    }

    public void setLoading(boolean z) {
        this.fEk = z;
    }
}
