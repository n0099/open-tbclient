package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cNP;
    private com.baidu.tieba.setting.im.more.a dhf;
    private String dhg;
    private String dhh;
    private String dhi;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aDr() {
        return this.dhf;
    }

    public String aDs() {
        return this.dhg;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cNP = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cNP = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aDt() {
        return new PrivateInfoNetMessage();
    }

    public boolean aDu() {
        if (this.cNP) {
            return false;
        }
        this.cNP = true;
        this.mFinished = false;
        sendMessage(aDt());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dhf = aVar;
        aDv();
    }

    private void aDv() {
        SimpleUser aDw = aDw();
        if (aDw != null) {
            this.dhh = aDw.secureemail;
            this.dhi = aDw.securemobil;
            this.dhg = aDw.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aDw() {
        if (this.dhf == null || this.dhf.aDw() == null) {
            return null;
        }
        return this.dhf.aDw();
    }

    public boolean isLoading() {
        return this.cNP;
    }

    public void setLoading(boolean z) {
        this.cNP = z;
    }
}
