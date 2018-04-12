package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aMu;
    private com.baidu.tieba.setting.im.more.a bcF;
    private String bcG;
    private String bcH;
    private String bcI;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a MU() {
        return this.bcF;
    }

    public String MV() {
        return this.bcG;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aMu = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aMu = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage MW() {
        return new PrivateInfoNetMessage();
    }

    public boolean MX() {
        if (this.aMu) {
            return false;
        }
        this.aMu = true;
        this.mFinished = false;
        sendMessage(MW());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bcF = aVar;
        MY();
    }

    private void MY() {
        SimpleUser MZ = MZ();
        if (MZ != null) {
            this.bcH = MZ.secureemail;
            this.bcI = MZ.securemobil;
            this.bcG = MZ.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser MZ() {
        if (this.bcF == null || this.bcF.MZ() == null) {
            return null;
        }
        return this.bcF.MZ();
    }

    public boolean wX() {
        return this.aMu;
    }

    public void setLoading(boolean z) {
        this.aMu = z;
    }
}
