package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import d.a.n0.w2.b.a.a;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13528e;

    /* renamed from: f  reason: collision with root package name */
    public a f13529f;

    /* renamed from: g  reason: collision with root package name */
    public String f13530g;

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f13528e = false;
    }

    public boolean A() {
        return this.f13528e;
    }

    public final void B() {
        SimpleUser z = z();
        if (z != null) {
            String str = z.secureemail;
            String str2 = z.securemobil;
            this.f13530g = z.ahead_url;
        }
    }

    public boolean C() {
        if (this.f13528e) {
            return false;
        }
        this.f13528e = true;
        sendMessage(w());
        return true;
    }

    public void D(a aVar) {
        this.f13529f = aVar;
        B();
    }

    public void E(boolean z) {
        this.f13528e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f13528e = false;
        return false;
    }

    public final PrivateInfoNetMessage w() {
        return new PrivateInfoNetMessage();
    }

    public a x() {
        return this.f13529f;
    }

    public String y() {
        return this.f13530g;
    }

    public final SimpleUser z() {
        a aVar = this.f13529f;
        if (aVar == null || aVar.f() == null) {
            return null;
        }
        return this.f13529f.f();
    }
}
