package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import d.a.j0.v2.b.a.a;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f14222e;

    /* renamed from: f  reason: collision with root package name */
    public a f14223f;

    /* renamed from: g  reason: collision with root package name */
    public String f14224g;

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f14222e = false;
    }

    public void A(boolean z) {
        this.f14222e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f14222e = false;
        return false;
    }

    public final PrivateInfoNetMessage s() {
        return new PrivateInfoNetMessage();
    }

    public a t() {
        return this.f14223f;
    }

    public String u() {
        return this.f14224g;
    }

    public final SimpleUser v() {
        a aVar = this.f14223f;
        if (aVar == null || aVar.f() == null) {
            return null;
        }
        return this.f14223f.f();
    }

    public boolean w() {
        return this.f14222e;
    }

    public final void x() {
        SimpleUser v = v();
        if (v != null) {
            String str = v.secureemail;
            String str2 = v.securemobil;
            this.f14224g = v.ahead_url;
        }
    }

    public boolean y() {
        if (this.f14222e) {
            return false;
        }
        this.f14222e = true;
        sendMessage(s());
        return true;
    }

    public void z(a aVar) {
        this.f14223f = aVar;
        x();
    }
}
