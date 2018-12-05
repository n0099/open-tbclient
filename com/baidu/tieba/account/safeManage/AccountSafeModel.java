package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a bBb;
    private String bBc;
    private String bBd;
    private String bBe;
    private boolean bht;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a VZ() {
        return this.bBb;
    }

    public String Wa() {
        return this.bBc;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bht = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bht = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Wb() {
        return new PrivateInfoNetMessage();
    }

    public boolean Wc() {
        if (this.bht) {
            return false;
        }
        this.bht = true;
        this.mFinished = false;
        sendMessage(Wb());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bBb = aVar;
        Wd();
    }

    private void Wd() {
        SimpleUser We = We();
        if (We != null) {
            this.bBd = We.secureemail;
            this.bBe = We.securemobil;
            this.bBc = We.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser We() {
        if (this.bBb == null || this.bBb.We() == null) {
            return null;
        }
        return this.bBb.We();
    }

    public boolean Fi() {
        return this.bht;
    }

    public void setLoading(boolean z) {
        this.bht = z;
    }
}
