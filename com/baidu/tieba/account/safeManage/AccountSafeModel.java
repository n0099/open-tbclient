package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a cMW;
    private String cMX;
    private String cMY;
    private String cMZ;
    private boolean csd;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a awx() {
        return this.cMW;
    }

    public String awy() {
        return this.cMX;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.csd = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.csd = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage awz() {
        return new PrivateInfoNetMessage();
    }

    public boolean awA() {
        if (this.csd) {
            return false;
        }
        this.csd = true;
        this.mFinished = false;
        sendMessage(awz());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cMW = aVar;
        awB();
    }

    private void awB() {
        SimpleUser awC = awC();
        if (awC != null) {
            this.cMY = awC.secureemail;
            this.cMZ = awC.securemobil;
            this.cMX = awC.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser awC() {
        if (this.cMW == null || this.cMW.awC() == null) {
            return null;
        }
        return this.cMW.awC();
    }

    public boolean qz() {
        return this.csd;
    }

    public void setLoading(boolean z) {
        this.csd = z;
    }
}
