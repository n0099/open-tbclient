package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean bdS;
    private com.baidu.tieba.setting.im.more.a bxE;
    private String bxF;
    private String bxG;
    private String bxH;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a UT() {
        return this.bxE;
    }

    public String UU() {
        return this.bxF;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bdS = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.bdS = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage UV() {
        return new PrivateInfoNetMessage();
    }

    public boolean UW() {
        if (this.bdS) {
            return false;
        }
        this.bdS = true;
        this.mFinished = false;
        sendMessage(UV());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.bxE = aVar;
        UX();
    }

    private void UX() {
        SimpleUser UY = UY();
        if (UY != null) {
            this.bxG = UY.secureemail;
            this.bxH = UY.securemobil;
            this.bxF = UY.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser UY() {
        if (this.bxE == null || this.bxE.UY() == null) {
            return null;
        }
        return this.bxE.UY();
    }

    public boolean Ee() {
        return this.bdS;
    }

    public void setLoading(boolean z) {
        this.bdS = z;
    }
}
