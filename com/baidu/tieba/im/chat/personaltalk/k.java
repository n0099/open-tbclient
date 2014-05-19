package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.editortool.ab;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class k {
    private DataRes c;
    private ab g;
    private PersonalTalkSettingActivity h;
    private p i;
    private com.baidu.tbadk.coreExtra.b.a b = new com.baidu.tbadk.coreExtra.b.a(null);
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    com.baidu.tieba.im.model.b a = new com.baidu.tieba.im.model.b();
    private com.baidu.adp.framework.listener.b j = new l(this, 0);
    private CustomMessageListener k = new m(this, 0);

    public boolean a() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public DataRes b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public k(PersonalTalkSettingActivity personalTalkSettingActivity, p pVar, long j) {
        this.h = personalTalkSettingActivity;
        this.i = pVar;
        this.a.setUniqueId(personalTalkSettingActivity.getUniqueId());
        personalTalkSettingActivity.showProgressBar();
        this.g = new ab(personalTalkSettingActivity);
        com.baidu.tieba.im.i.a(new n(this, j), new o(this, j, personalTalkSettingActivity));
    }

    public void e() {
        if (this.b != null && this.c != null) {
            this.b.a(!this.d, this.c.portrait, String.valueOf(this.c.id));
        }
    }

    public void b(boolean z) {
        this.h.showLoadingDialog(null);
        if (z) {
            this.a.a(this.c.id.longValue());
        } else {
            this.a.b(this.c.id.longValue());
        }
    }

    public ab f() {
        return this.g;
    }

    public void g() {
        if (this.g != null) {
            this.g.d();
        }
        if (this.b != null) {
            this.b.a();
        }
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.b h() {
        return this.j;
    }

    public CustomMessageListener i() {
        return this.k;
    }
}
