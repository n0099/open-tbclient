package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import d.b.i0.v2.b.a.a;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f14164e;

    /* renamed from: f  reason: collision with root package name */
    public a f14165f;

    /* renamed from: g  reason: collision with root package name */
    public String f14166g;

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f14164e = false;
    }

    public void A(boolean z) {
        this.f14164e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f14164e = false;
        return false;
    }

    public final PrivateInfoNetMessage s() {
        return new PrivateInfoNetMessage();
    }

    public a t() {
        return this.f14165f;
    }

    public String u() {
        return this.f14166g;
    }

    public final SimpleUser v() {
        a aVar = this.f14165f;
        if (aVar == null || aVar.f() == null) {
            return null;
        }
        return this.f14165f.f();
    }

    public boolean w() {
        return this.f14164e;
    }

    public final void x() {
        SimpleUser v = v();
        if (v != null) {
            String str = v.secureemail;
            String str2 = v.securemobil;
            this.f14166g = v.ahead_url;
        }
    }

    public boolean y() {
        if (this.f14164e) {
            return false;
        }
        this.f14164e = true;
        sendMessage(s());
        return true;
    }

    public void z(a aVar) {
        this.f14165f = aVar;
        x();
    }
}
