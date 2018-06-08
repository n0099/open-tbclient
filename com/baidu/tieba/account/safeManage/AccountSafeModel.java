package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aUt;
    private com.baidu.tieba.setting.im.more.a bkQ;
    private String bkR;
    private String bkS;
    private String bkT;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Qr() {
        return this.bkQ;
    }

    public String Qs() {
        return this.bkR;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aUt = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aUt = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Qt() {
        return new PrivateInfoNetMessage();
    }

    public boolean Qu() {
        if (this.aUt) {
            return false;
        }
        this.aUt = true;
        this.mFinished = false;
        sendMessage(Qt());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bkQ = aVar;
        Qv();
    }

    private void Qv() {
        SimpleUser Qw = Qw();
        if (Qw != null) {
            this.bkS = Qw.secureemail;
            this.bkT = Qw.securemobil;
            this.bkR = Qw.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Qw() {
        if (this.bkQ == null || this.bkQ.Qw() == null) {
            return null;
        }
        return this.bkQ.Qw();
    }

    public boolean Ax() {
        return this.aUt;
    }

    public void setLoading(boolean z) {
        this.aUt = z;
    }
}
