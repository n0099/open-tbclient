package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.im.s;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class k {
    private QueryUserInfosRes.DataRes c;
    private aa g;
    private PersonalTalkSettingActivity h;
    private p i;
    private com.baidu.tbadk.coreExtra.b.a b = new com.baidu.tbadk.coreExtra.b.a(null);
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    com.baidu.tieba.im.model.b a = new com.baidu.tieba.im.model.b();
    private com.baidu.adp.framework.c.g j = new l(this, 0);
    private com.baidu.adp.framework.c.a k = new m(this, 0);

    public final boolean a() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final QueryUserInfosRes.DataRes b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.e;
    }

    public k(PersonalTalkSettingActivity personalTalkSettingActivity, p pVar, long j) {
        this.h = personalTalkSettingActivity;
        this.i = pVar;
        this.a.setUniqueId(personalTalkSettingActivity.getUniqueId());
        personalTalkSettingActivity.showProgressBar();
        this.g = new aa(personalTalkSettingActivity);
        s.a(new n(this, j), new o(this, j, personalTalkSettingActivity));
    }

    public final void e() {
        if (this.b != null && this.c != null) {
            this.b.a(!this.d, this.c.getPortrait(), String.valueOf(this.c.getId()));
        }
    }

    public final void b(boolean z) {
        this.h.showLoadingDialog(null);
        if (z) {
            this.a.a(this.c.getId());
        } else {
            this.a.b(this.c.getId());
        }
    }

    public final aa f() {
        return this.g;
    }

    public final void g() {
        if (this.g != null) {
            this.g.c();
        }
        if (this.b != null) {
            this.b.a();
        }
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    public final com.baidu.adp.framework.c.g h() {
        return this.j;
    }

    public final com.baidu.adp.framework.c.a i() {
        return this.k;
    }
}
