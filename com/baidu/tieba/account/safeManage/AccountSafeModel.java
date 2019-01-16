package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a bBR;
    private String bBS;
    private String bBT;
    private String bBU;
    private boolean bii;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Wx() {
        return this.bBR;
    }

    public String Wy() {
        return this.bBS;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bii = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bii = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Wz() {
        return new PrivateInfoNetMessage();
    }

    public boolean WA() {
        if (this.bii) {
            return false;
        }
        this.bii = true;
        this.mFinished = false;
        sendMessage(Wz());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bBR = aVar;
        WB();
    }

    private void WB() {
        SimpleUser WC = WC();
        if (WC != null) {
            this.bBT = WC.secureemail;
            this.bBU = WC.securemobil;
            this.bBS = WC.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser WC() {
        if (this.bBR == null || this.bBR.WC() == null) {
            return null;
        }
        return this.bBR.WC();
    }

    public boolean Fv() {
        return this.bii;
    }

    public void setLoading(boolean z) {
        this.bii = z;
    }
}
