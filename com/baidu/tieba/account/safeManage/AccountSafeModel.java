package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aVq;
    private com.baidu.tieba.setting.im.more.a bmY;
    private String bmZ;
    private String bna;
    private String bnb;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Ra() {
        return this.bmY;
    }

    public String Rb() {
        return this.bmZ;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aVq = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aVq = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Rc() {
        return new PrivateInfoNetMessage();
    }

    public boolean Rd() {
        if (this.aVq) {
            return false;
        }
        this.aVq = true;
        this.mFinished = false;
        sendMessage(Rc());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bmY = aVar;
        Re();
    }

    private void Re() {
        SimpleUser Rf = Rf();
        if (Rf != null) {
            this.bna = Rf.secureemail;
            this.bnb = Rf.securemobil;
            this.bmZ = Rf.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Rf() {
        if (this.bmY == null || this.bmY.Rf() == null) {
            return null;
        }
        return this.bmY.Rf();
    }

    public boolean AB() {
        return this.aVq;
    }

    public void setLoading(boolean z) {
        this.aVq = z;
    }
}
