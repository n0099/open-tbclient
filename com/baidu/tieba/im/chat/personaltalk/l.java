package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bj;
import com.baidu.tieba.im.message.cn;
import com.baidu.tieba.im.message.cx;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.de;
import com.baidu.tieba.im.message.s;
import com.slidingmenu.lib.R;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class l implements com.baidu.tieba.im.messageCenter.g {
    private QueryUserInfosRes.DataRes c;
    private com.baidu.tieba.util.i g;
    private PersonalTalkSettingActivity h;
    private o i;
    private com.baidu.tieba.model.d b = new com.baidu.tieba.model.d(null);
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    com.baidu.tieba.im.model.b a = new com.baidu.tieba.im.model.b();

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

    public l(PersonalTalkSettingActivity personalTalkSettingActivity, o oVar, long j) {
        this.h = personalTalkSettingActivity;
        this.i = oVar;
        personalTalkSettingActivity.showProgressBar();
        this.g = new com.baidu.tieba.util.i(personalTalkSettingActivity);
        com.baidu.tieba.im.i.a(new m(this, j), new n(this, j));
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

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        if (sVar != null) {
            switch (sVar.w()) {
                case -118:
                    if (sVar instanceof de) {
                        de deVar = (de) sVar;
                        if (deVar.a()) {
                            this.d = deVar.d();
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
                        } else if (this.h != null && !TextUtils.isEmpty(deVar.b())) {
                            this.h.showToast(deVar.b());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 104102:
                    if (sVar instanceof da) {
                        this.h.closeLoadingDialog();
                        if (((da) sVar).l()) {
                            this.h.showToast(((da) sVar).n());
                        }
                    }
                    if (sVar instanceof cx) {
                        cx cxVar = (cx) sVar;
                        if (cxVar.o() instanceof bj) {
                            bj bjVar = (bj) cxVar.o();
                            if (bjVar.b() == 10) {
                                this.e = bjVar.c() == 1;
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
                    if ((sVar instanceof da) && ((da) sVar).l()) {
                        this.h.hideProgressBar();
                        this.h.showToast(((da) sVar).n());
                        return;
                    } else if (sVar instanceof cn) {
                        cn cnVar = (cn) sVar;
                        if (cnVar.a() != null) {
                            this.c = cnVar.a();
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

    public final com.baidu.tieba.util.i f() {
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
}
