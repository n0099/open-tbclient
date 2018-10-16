package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean bdf;
    private com.baidu.tieba.setting.im.more.a bwT;
    private String bwU;
    private String bwV;
    private String bwW;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a UK() {
        return this.bwT;
    }

    public String UL() {
        return this.bwU;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bdf = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bdf = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage UM() {
        return new PrivateInfoNetMessage();
    }

    public boolean UN() {
        if (this.bdf) {
            return false;
        }
        this.bdf = true;
        this.mFinished = false;
        sendMessage(UM());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bwT = aVar;
        UO();
    }

    private void UO() {
        SimpleUser UP = UP();
        if (UP != null) {
            this.bwV = UP.secureemail;
            this.bwW = UP.securemobil;
            this.bwU = UP.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser UP() {
        if (this.bwT == null || this.bwT.UP() == null) {
            return null;
        }
        return this.bwT.UP();
    }

    public boolean DU() {
        return this.bdf;
    }

    public void setLoading(boolean z) {
        this.bdf = z;
    }
}
