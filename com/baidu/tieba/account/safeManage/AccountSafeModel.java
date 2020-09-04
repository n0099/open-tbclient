package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes16.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean eTN;
    private com.baidu.tieba.setting.im.more.a fnO;
    private String fnP;
    private String fnQ;
    private String fnR;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bAO() {
        return this.fnO;
    }

    public String Cv() {
        return this.fnP;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eTN = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.eTN = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bAP() {
        return new PrivateInfoNetMessage();
    }

    public boolean bAQ() {
        if (this.eTN) {
            return false;
        }
        this.eTN = true;
        this.mFinished = false;
        sendMessage(bAP());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fnO = aVar;
        bAR();
    }

    private void bAR() {
        SimpleUser bAS = bAS();
        if (bAS != null) {
            this.fnQ = bAS.secureemail;
            this.fnR = bAS.securemobil;
            this.fnP = bAS.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bAS() {
        if (this.fnO == null || this.fnO.bAS() == null) {
            return null;
        }
        return this.fnO.bAS();
    }

    public boolean isLoading() {
        return this.eTN;
    }

    public void setLoading(boolean z) {
        this.eTN = z;
    }
}
