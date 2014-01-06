package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.tieba.im.message.aw;
import com.baidu.tieba.im.message.bt;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.cf;
import com.slidingmenu.lib.R;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.messageCenter.g {
    private QueryUserInfosRes.DataRes c;
    private com.baidu.tieba.util.i g;
    private PersonalTalkSettingActivity h;
    private n i;
    private com.baidu.tieba.model.e b = new com.baidu.tieba.model.e(null);
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    com.baidu.tieba.im.model.b a = new com.baidu.tieba.im.model.b();

    public boolean a() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public QueryUserInfosRes.DataRes b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public k(PersonalTalkSettingActivity personalTalkSettingActivity, n nVar, long j) {
        this.h = personalTalkSettingActivity;
        this.i = nVar;
        personalTalkSettingActivity.showProgressBar();
        this.g = new com.baidu.tieba.util.i(personalTalkSettingActivity);
        com.baidu.tieba.im.m.a(new l(this, j), new m(this, j));
    }

    public void e() {
        if (this.b != null && this.c != null) {
            this.b.a(!this.d, this.c.getPortrait(), String.valueOf(this.c.getId()));
        }
    }

    public void b(boolean z) {
        this.h.showLoadingDialog(null);
        if (z) {
            this.a.a(this.c.getId());
        } else {
            this.a.b(this.c.getId());
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null) {
            switch (oVar.u()) {
                case -118:
                    if (oVar instanceof cf) {
                        cf cfVar = (cf) oVar;
                        if (cfVar.a()) {
                            this.d = cfVar.d();
                            if (this.h != null) {
                                if (this.d) {
                                    this.h.showToast(R.string.add_succ);
                                } else {
                                    this.h.showToast(R.string.remove_succ);
                                }
                            }
                            if (this.i != null) {
                                this.i.a();
                                return;
                            }
                            return;
                        } else if (this.h != null && !TextUtils.isEmpty(cfVar.b())) {
                            this.h.showToast(cfVar.b());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 104102:
                    if (oVar instanceof cc) {
                        this.h.closeLoadingDialog();
                        if (((cc) oVar).i()) {
                            this.h.showToast(((cc) oVar).k());
                        }
                    }
                    if (oVar instanceof ca) {
                        ca caVar = (ca) oVar;
                        if (caVar.l() instanceof aw) {
                            aw awVar = (aw) caVar.l();
                            if (awVar.b() == 10) {
                                this.e = awVar.c() == 1;
                                if (this.i != null) {
                                    this.i.a();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 205003:
                    if ((oVar instanceof cc) && ((cc) oVar).i()) {
                        this.h.hideProgressBar();
                        this.h.showToast(((cc) oVar).k());
                        return;
                    } else if (oVar instanceof bt) {
                        bt btVar = (bt) oVar;
                        if (btVar.a() != null) {
                            this.c = btVar.a();
                            this.d = this.c.getHasConcerned() == 1;
                            this.e = this.c.getIsBlacklist() == 1;
                            this.h.hideProgressBar();
                            if (this.i != null) {
                                this.i.a();
                                return;
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public com.baidu.tieba.util.i f() {
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
}
