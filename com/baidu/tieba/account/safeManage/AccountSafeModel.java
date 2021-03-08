package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fMT;
    private com.baidu.tieba.setting.im.more.a gig;
    private String gih;
    private String gii;
    private String gij;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bLl() {
        return this.gig;
    }

    public String BV() {
        return this.gih;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fMT = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fMT = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bLm() {
        return new PrivateInfoNetMessage();
    }

    public boolean bLn() {
        if (this.fMT) {
            return false;
        }
        this.fMT = true;
        this.mFinished = false;
        sendMessage(bLm());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.gig = aVar;
        bLo();
    }

    private void bLo() {
        SimpleUser bLp = bLp();
        if (bLp != null) {
            this.gii = bLp.secureemail;
            this.gij = bLp.securemobil;
            this.gih = bLp.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bLp() {
        if (this.gig == null || this.gig.bLp() == null) {
            return null;
        }
        return this.gig.bLp();
    }

    public boolean isLoading() {
        return this.fMT;
    }

    public void setLoading(boolean z) {
        this.fMT = z;
    }
}
