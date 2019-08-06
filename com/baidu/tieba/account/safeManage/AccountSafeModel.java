package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cBK;
    private com.baidu.tieba.setting.im.more.a cWP;
    private String cWQ;
    private String cWR;
    private String cWS;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aCU() {
        return this.cWP;
    }

    public String aCV() {
        return this.cWQ;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cBK = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cBK = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aCW() {
        return new PrivateInfoNetMessage();
    }

    public boolean aCX() {
        if (this.cBK) {
            return false;
        }
        this.cBK = true;
        this.mFinished = false;
        sendMessage(aCW());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.cWP = aVar;
        aCY();
    }

    private void aCY() {
        SimpleUser aCZ = aCZ();
        if (aCZ != null) {
            this.cWR = aCZ.secureemail;
            this.cWS = aCZ.securemobil;
            this.cWQ = aCZ.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aCZ() {
        if (this.cWP == null || this.cWP.aCZ() == null) {
            return null;
        }
        return this.cWP.aCZ();
    }

    public boolean pP() {
        return this.cBK;
    }

    public void setLoading(boolean z) {
        this.cBK = z;
    }
}
