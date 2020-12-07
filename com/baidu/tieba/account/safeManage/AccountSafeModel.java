package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes22.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fEk;
    private com.baidu.tieba.setting.im.more.a fZi;
    private String fZj;
    private String fZk;
    private String fZl;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bMg() {
        return this.fZi;
    }

    public String Fk() {
        return this.fZj;
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

    private PrivateInfoNetMessage bMh() {
        return new PrivateInfoNetMessage();
    }

    public boolean bMi() {
        if (this.fEk) {
            return false;
        }
        this.fEk = true;
        this.mFinished = false;
        sendMessage(bMh());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fZi = aVar;
        bMj();
    }

    private void bMj() {
        SimpleUser bMk = bMk();
        if (bMk != null) {
            this.fZk = bMk.secureemail;
            this.fZl = bMk.securemobil;
            this.fZj = bMk.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bMk() {
        if (this.fZi == null || this.fZi.bMk() == null) {
            return null;
        }
        return this.fZi.bMk();
    }

    public boolean isLoading() {
        return this.fEk;
    }

    public void setLoading(boolean z) {
        this.fEk = z;
    }
}
