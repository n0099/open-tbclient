package com.baidu.tieba.account.safeManage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.im.more.PrivateInfoNetMessage;
import d.a.n0.w2.b.a.a;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class AccountSafeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13463e;

    /* renamed from: f  reason: collision with root package name */
    public a f13464f;

    /* renamed from: g  reason: collision with root package name */
    public String f13465g;

    public AccountSafeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.f13463e = false;
    }

    public void A(boolean z) {
        this.f13463e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.f13463e = false;
        return false;
    }

    public final PrivateInfoNetMessage s() {
        return new PrivateInfoNetMessage();
    }

    public a t() {
        return this.f13464f;
    }

    public String u() {
        return this.f13465g;
    }

    public final SimpleUser v() {
        a aVar = this.f13464f;
        if (aVar == null || aVar.f() == null) {
            return null;
        }
        return this.f13464f.f();
    }

    public boolean w() {
        return this.f13463e;
    }

    public final void x() {
        SimpleUser v = v();
        if (v != null) {
            String str = v.secureemail;
            String str2 = v.securemobil;
            this.f13465g = v.ahead_url;
        }
    }

    public boolean y() {
        if (this.f13463e) {
            return false;
        }
        this.f13463e = true;
        sendMessage(s());
        return true;
    }

    public void z(a aVar) {
        this.f13464f = aVar;
        x();
    }
}
