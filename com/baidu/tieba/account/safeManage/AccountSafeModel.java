package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fJi;
    private com.baidu.tieba.setting.im.more.a gei;
    private String gej;
    private String gek;
    private String gel;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bKI() {
        return this.gei;
    }

    public String AF() {
        return this.gej;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fJi = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fJi = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bKJ() {
        return new PrivateInfoNetMessage();
    }

    public boolean bKK() {
        if (this.fJi) {
            return false;
        }
        this.fJi = true;
        this.mFinished = false;
        sendMessage(bKJ());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.gei = aVar;
        bKL();
    }

    private void bKL() {
        SimpleUser bKM = bKM();
        if (bKM != null) {
            this.gek = bKM.secureemail;
            this.gel = bKM.securemobil;
            this.gej = bKM.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bKM() {
        if (this.gei == null || this.gei.bKM() == null) {
            return null;
        }
        return this.gei.bKM();
    }

    public boolean isLoading() {
        return this.fJi;
    }

    public void setLoading(boolean z) {
        this.fJi = z;
    }
}
