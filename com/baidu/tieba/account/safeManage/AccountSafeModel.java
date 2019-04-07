package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a cMY;
    private String cMZ;
    private String cNa;
    private String cNb;
    private boolean csf;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a awu() {
        return this.cMY;
    }

    public String awv() {
        return this.cMZ;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.csf = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.csf = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aww() {
        return new PrivateInfoNetMessage();
    }

    public boolean awx() {
        if (this.csf) {
            return false;
        }
        this.csf = true;
        this.mFinished = false;
        sendMessage(aww());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cMY = aVar;
        awy();
    }

    private void awy() {
        SimpleUser awz = awz();
        if (awz != null) {
            this.cNa = awz.secureemail;
            this.cNb = awz.securemobil;
            this.cMZ = awz.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser awz() {
        if (this.cMY == null || this.cMY.awz() == null) {
            return null;
        }
        return this.cMY.awz();
    }

    public boolean qz() {
        return this.csf;
    }

    public void setLoading(boolean z) {
        this.csf = z;
    }
}
