package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a bBe;
    private String bBf;
    private String bBg;
    private String bBh;
    private boolean bhw;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a Wb() {
        return this.bBe;
    }

    public String Wc() {
        return this.bBf;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bhw = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bhw = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage Wd() {
        return new PrivateInfoNetMessage();
    }

    public boolean We() {
        if (this.bhw) {
            return false;
        }
        this.bhw = true;
        this.mFinished = false;
        sendMessage(Wd());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bBe = aVar;
        Wf();
    }

    private void Wf() {
        SimpleUser Wg = Wg();
        if (Wg != null) {
            this.bBg = Wg.secureemail;
            this.bBh = Wg.securemobil;
            this.bBf = Wg.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser Wg() {
        if (this.bBe == null || this.bBe.Wg() == null) {
            return null;
        }
        return this.bBe.Wg();
    }

    public boolean Fi() {
        return this.bhw;
    }

    public void setLoading(boolean z) {
        this.bhw = z;
    }
}
