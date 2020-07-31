package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes16.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean eJd;
    private com.baidu.tieba.setting.im.more.a fcr;
    private String fcs;
    private String fct;
    private String fcu;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a brQ() {
        return this.fcr;
    }

    public String wX() {
        return this.fcs;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eJd = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.eJd = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage brR() {
        return new PrivateInfoNetMessage();
    }

    public boolean brS() {
        if (this.eJd) {
            return false;
        }
        this.eJd = true;
        this.mFinished = false;
        sendMessage(brR());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fcr = aVar;
        brT();
    }

    private void brT() {
        SimpleUser brU = brU();
        if (brU != null) {
            this.fct = brU.secureemail;
            this.fcu = brU.securemobil;
            this.fcs = brU.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser brU() {
        if (this.fcr == null || this.fcr.brU() == null) {
            return null;
        }
        return this.fcr.brU();
    }

    public boolean isLoading() {
        return this.eJd;
    }

    public void setLoading(boolean z) {
        this.eJd = z;
    }
}
