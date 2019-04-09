package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a cMZ;
    private String cNa;
    private String cNb;
    private String cNc;
    private boolean csg;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a awu() {
        return this.cMZ;
    }

    public String awv() {
        return this.cNa;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.csg = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.csg = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aww() {
        return new PrivateInfoNetMessage();
    }

    public boolean awx() {
        if (this.csg) {
            return false;
        }
        this.csg = true;
        this.mFinished = false;
        sendMessage(aww());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cMZ = aVar;
        awy();
    }

    private void awy() {
        SimpleUser awz = awz();
        if (awz != null) {
            this.cNb = awz.secureemail;
            this.cNc = awz.securemobil;
            this.cNa = awz.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser awz() {
        if (this.cMZ == null || this.cMZ.awz() == null) {
            return null;
        }
        return this.cMZ.awz();
    }

    public boolean qz() {
        return this.csg;
    }

    public void setLoading(boolean z) {
        this.csg = z;
    }
}
