package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes16.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean eTJ;
    private com.baidu.tieba.setting.im.more.a fnK;
    private String fnL;
    private String fnM;
    private String fnN;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bAN() {
        return this.fnK;
    }

    public String Cv() {
        return this.fnL;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eTJ = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.eTJ = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bAO() {
        return new PrivateInfoNetMessage();
    }

    public boolean bAP() {
        if (this.eTJ) {
            return false;
        }
        this.eTJ = true;
        this.mFinished = false;
        sendMessage(bAO());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.fnK = aVar;
        bAQ();
    }

    private void bAQ() {
        SimpleUser bAR = bAR();
        if (bAR != null) {
            this.fnM = bAR.secureemail;
            this.fnN = bAR.securemobil;
            this.fnL = bAR.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bAR() {
        if (this.fnK == null || this.fnK.bAR() == null) {
            return null;
        }
        return this.fnK.bAR();
    }

    public boolean isLoading() {
        return this.eTJ;
    }

    public void setLoading(boolean z) {
        this.eTJ = z;
    }
}
