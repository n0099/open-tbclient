package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class AccountSafeModel extends BdBaseModel {
    private boolean fLt;
    private String ggA;
    private com.baidu.tieba.setting.im.more.a ggx;
    private String ggy;
    private String ggz;
    private boolean mFinished;

    public com.baidu.tieba.setting.im.more.a bLc() {
        return this.ggx;
    }

    public String BS() {
        return this.ggy;
    }

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fLt = false;
        this.mFinished = false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.fLt = false;
        this.mFinished = false;
        return false;
    }

    private PrivateInfoNetMessage bLd() {
        return new PrivateInfoNetMessage();
    }

    public boolean bLe() {
        if (this.fLt) {
            return false;
        }
        this.fLt = true;
        this.mFinished = false;
        sendMessage(bLd());
        return true;
    }

    public void a(com.baidu.tieba.setting.im.more.a aVar) {
        this.ggx = aVar;
        bLf();
    }

    private void bLf() {
        SimpleUser bLg = bLg();
        if (bLg != null) {
            this.ggz = bLg.secureemail;
            this.ggA = bLg.securemobil;
            this.ggy = bLg.ahead_url;
            this.mFinished = true;
        }
    }

    private SimpleUser bLg() {
        if (this.ggx == null || this.ggx.bLg() == null) {
            return null;
        }
        return this.ggx.bLg();
    }

    public boolean isLoading() {
        return this.fLt;
    }

    public void setLoading(boolean z) {
        this.fLt = z;
    }
}
