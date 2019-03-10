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

    public com.baidu.tieba.setting.im.more.a awy() {
        return this.cMZ;
    }

    public String awz() {
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

    private PrivateInfoNetMessage awA() {
        return new PrivateInfoNetMessage();
    }

    public boolean awB() {
        if (this.csf) {
            return false;
        }
        this.csf = true;
        this.mFinished = false;
        sendMessage(awA());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cMZ = aVar;
        awC();
    }

    private void awC() {
        SimpleUser awD = awD();
        if (awD != null) {
            this.cNb = awD.secureemail;
            this.cNc = awD.securemobil;
            this.cNa = awD.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser awD() {
        if (this.cMZ == null || this.cMZ.awD() == null) {
            return null;
        }
        return this.cMZ.awD();
    }

    public boolean qz() {
        return this.csf;
    }

    public void setLoading(boolean z) {
        this.csf = z;
    }
}
