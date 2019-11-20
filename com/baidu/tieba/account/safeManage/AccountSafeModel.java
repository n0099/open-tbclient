package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean cMY;
    private com.baidu.tieba.setting.im.more.a dgo;
    private String dgp;
    private String dgq;
    private String dgr;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a aDp() {
        return this.dgo;
    }

    public String aDq() {
        return this.dgp;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cMY = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.cMY = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage aDr() {
        return new PrivateInfoNetMessage();
    }

    public boolean aDs() {
        if (this.cMY) {
            return false;
        }
        this.cMY = true;
        this.mFinished = false;
        sendMessage(aDr());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.dgo = aVar;
        aDt();
    }

    private void aDt() {
        SimpleUser aDu = aDu();
        if (aDu != null) {
            this.dgq = aDu.secureemail;
            this.dgr = aDu.securemobil;
            this.dgp = aDu.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser aDu() {
        if (this.dgo == null || this.dgo.aDu() == null) {
            return null;
        }
        return this.dgo.aDu();
    }

    public boolean isLoading() {
        return this.cMY;
    }

    public void setLoading(boolean z) {
        this.cMY = z;
    }
}
