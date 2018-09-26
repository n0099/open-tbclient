package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean aYF;
    private com.baidu.tieba.setting.im.more.a bsM;
    private String bsN;
    private String bsO;
    private String bsP;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a SO() {
        return this.bsM;
    }

    public String SP() {
        return this.bsN;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aYF = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.aYF = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage SQ() {
        return new PrivateInfoNetMessage();
    }

    public boolean SR() {
        if (this.aYF) {
            return false;
        }
        this.aYF = true;
        this.mFinished = false;
        sendMessage(SQ());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bsM = aVar;
        SS();
    }

    private void SS() {
        SimpleUser ST = ST();
        if (ST != null) {
            this.bsO = ST.secureemail;
            this.bsP = ST.securemobil;
            this.bsN = ST.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser ST() {
        if (this.bsM == null || this.bsM.ST() == null) {
            return null;
        }
        return this.bsM.ST();
    }

    public boolean BO() {
        return this.aYF;
    }

    public void setLoading(boolean z) {
        this.aYF = z;
    }
}
