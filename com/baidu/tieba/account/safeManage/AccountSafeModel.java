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
    private boolean csf;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a awx() {
        return this.cMZ;
    }

    public String awy() {
        return this.cNa;
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

    private PrivateInfoNetMessage awz() {
        return new PrivateInfoNetMessage();
    }

    public boolean awA() {
        if (this.csf) {
            return false;
        }
        this.csf = true;
        this.mFinished = false;
        sendMessage(awz());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cMZ = aVar;
        awB();
    }

    private void awB() {
        SimpleUser awC = awC();
        if (awC != null) {
            this.cNb = awC.secureemail;
            this.cNc = awC.securemobil;
            this.cNa = awC.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser awC() {
        if (this.cMZ == null || this.cMZ.awC() == null) {
            return null;
        }
        return this.cMZ.awC();
    }

    public boolean qz() {
        return this.csf;
    }

    public void setLoading(boolean z) {
        this.csf = z;
    }
}
