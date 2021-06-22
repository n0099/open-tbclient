package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import d.a.o0.w2.b.a.a;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13610e;

    /* renamed from: f  reason: collision with root package name */
    public a f13611f;

    /* renamed from: g  reason: collision with root package name */
    public String f13612g;

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f13610e = false;
    }

    public boolean A() {
        return this.f13610e;
    }

    public final void B() {
        SimpleUser z = z();
        if (z != null) {
            String str = z.secureemail;
            String str2 = z.securemobil;
            this.f13612g = z.ahead_url;
        }
    }

    public boolean C() {
        if (this.f13610e) {
            return false;
        }
        this.f13610e = true;
        sendMessage(w());
        return true;
    }

    public void D(a aVar) {
        this.f13611f = aVar;
        B();
    }

    public void E(boolean z) {
        this.f13610e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f13610e = false;
        return false;
    }

    public final PrivateInfoNetMessage w() {
        return new PrivateInfoNetMessage();
    }

    public a x() {
        return this.f13611f;
    }

    public String y() {
        return this.f13612g;
    }

    public final SimpleUser z() {
        a aVar = this.f13611f;
        if (aVar == null || aVar.f() == null) {
            return null;
        }
        return this.f13611f.f();
    }
}
