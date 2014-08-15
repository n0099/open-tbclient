package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.listener.CustomMessageListener;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class l {
    private DataRes b;
    private final com.baidu.tieba.im.model.b f;
    private PersonalTalkSettingActivity g;
    private q h;
    private com.baidu.tbadk.coreExtra.b.a a = new com.baidu.tbadk.coreExtra.b.a(null);
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private com.baidu.adp.framework.listener.d i = new m(this, 0);
    private CustomMessageListener j = new n(this, 0);

    public boolean a() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public DataRes b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public l(PersonalTalkSettingActivity personalTalkSettingActivity, q qVar, long j) {
        this.g = personalTalkSettingActivity;
        this.h = qVar;
        this.f = new com.baidu.tieba.im.model.b(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.e.a(new o(this, j), new p(this, j, personalTalkSettingActivity));
    }

    public void b(boolean z) {
        this.g.showLoadingDialog(null);
        if (z) {
            this.f.a(this.b.id.longValue());
        } else {
            this.f.b(this.b.id.longValue());
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.a();
        }
        if (this.f != null) {
            this.f.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.d e() {
        return this.i;
    }

    public CustomMessageListener f() {
        return this.j;
    }
}
