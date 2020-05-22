package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class AccountSafeModel extends BdBaseModel {
    private com.baidu.tieba.setting.im.more.a eNt;
    private String eNu;
    private String eNv;
    private String eNw;
    private boolean etX;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bmm() {
        return this.eNt;
    }

    public String vX() {
        return this.eNu;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.etX = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.etX = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bmn() {
        return new PrivateInfoNetMessage();
    }

    public boolean bmo() {
        if (this.etX) {
            return false;
        }
        this.etX = true;
        this.mFinished = false;
        sendMessage(bmn());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.eNt = aVar;
        bmp();
    }

    private void bmp() {
        SimpleUser bmq = bmq();
        if (bmq != null) {
            this.eNv = bmq.secureemail;
            this.eNw = bmq.securemobil;
            this.eNu = bmq.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bmq() {
        if (this.eNt == null || this.eNt.bmq() == null) {
            return null;
        }
        return this.eNt.bmq();
    }

    public boolean isLoading() {
        return this.etX;
    }

    public void setLoading(boolean z) {
        this.etX = z;
    }
}
