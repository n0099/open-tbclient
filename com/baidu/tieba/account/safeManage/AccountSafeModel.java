package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes22.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a fRr;
    private String fRs;
    private String fRt;
    private String fRu;
    private boolean fxg;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bJe() {
        return this.fRr;
    }

    public String Ei() {
        return this.fRs;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fxg = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fxg = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bJf() {
        return new PrivateInfoNetMessage();
    }

    public boolean bJg() {
        if (this.fxg) {
            return false;
        }
        this.fxg = true;
        this.mFinished = false;
        sendMessage(bJf());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fRr = aVar;
        bJh();
    }

    private void bJh() {
        SimpleUser bJi = bJi();
        if (bJi != null) {
            this.fRt = bJi.secureemail;
            this.fRu = bJi.securemobil;
            this.fRs = bJi.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bJi() {
        if (this.fRr == null || this.fRr.bJi() == null) {
            return null;
        }
        return this.fRr.bJi();
    }

    public boolean isLoading() {
        return this.fxg;
    }

    public void setLoading(boolean z) {
        this.fxg = z;
    }
}
