package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aMv;
    private com.baidu.tieba.setting.im.more.a bcG;
    private String bcH;
    private String bcI;
    private String bcJ;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a MS() {
        return this.bcG;
    }

    public String MT() {
        return this.bcH;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aMv = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aMv = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage MU() {
        return new PrivateInfoNetMessage();
    }

    public boolean MV() {
        if (this.aMv) {
            return false;
        }
        this.aMv = true;
        this.mFinished = false;
        sendMessage(MU());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bcG = aVar;
        MW();
    }

    private void MW() {
        SimpleUser MX = MX();
        if (MX != null) {
            this.bcI = MX.secureemail;
            this.bcJ = MX.securemobil;
            this.bcH = MX.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser MX() {
        if (this.bcG == null || this.bcG.MX() == null) {
            return null;
        }
        return this.bcG.MX();
    }

    public boolean wW() {
        return this.aMv;
    }

    public void setLoading(boolean z) {
        this.aMv = z;
    }
}
