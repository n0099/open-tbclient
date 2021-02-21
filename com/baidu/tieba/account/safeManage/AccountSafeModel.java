package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fLt;
    private com.baidu.tieba.setting.im.more.a ggC;
    private String ggD;
    private String ggE;
    private String ggF;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bLh() {
        return this.ggC;
    }

    public String BS() {
        return this.ggD;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fLt = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fLt = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bLi() {
        return new PrivateInfoNetMessage();
    }

    public boolean bLj() {
        if (this.fLt) {
            return false;
        }
        this.fLt = true;
        this.mFinished = false;
        sendMessage(bLi());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.ggC = aVar;
        bLk();
    }

    private void bLk() {
        SimpleUser bLl = bLl();
        if (bLl != null) {
            this.ggE = bLl.secureemail;
            this.ggF = bLl.securemobil;
            this.ggD = bLl.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bLl() {
        if (this.ggC == null || this.ggC.bLl() == null) {
            return null;
        }
        return this.ggC.bLl();
    }

    public boolean isLoading() {
        return this.fLt;
    }

    public void setLoading(boolean z) {
        this.fLt = z;
    }
}
