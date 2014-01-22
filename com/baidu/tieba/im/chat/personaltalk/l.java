package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bd;
import com.baidu.tieba.im.message.ce;
import com.baidu.tieba.im.message.co;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.cv;
import com.slidingmenu.lib.R;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.messageCenter.g {
    private QueryUserInfosRes.DataRes c;
    private com.baidu.tieba.util.i g;
    private PersonalTalkSettingActivity h;
    private o i;
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

    public l(PersonalTalkSettingActivity personalTalkSettingActivity, o oVar, long j) {
        this.h = personalTalkSettingActivity;
        this.i = oVar;
        personalTalkSettingActivity.showProgressBar();
        this.g = new com.baidu.tieba.util.i(personalTalkSettingActivity);
        com.baidu.tieba.im.m.a(new m(this, j), new n(this, j));
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
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null) {
            switch (qVar.w()) {
                case -118:
                    if (qVar instanceof cv) {
                        cv cvVar = (cv) qVar;
                        if (cvVar.a()) {
                            this.d = cvVar.d();
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
                        } else if (this.h != null && !TextUtils.isEmpty(cvVar.b())) {
                            this.h.showToast(cvVar.b());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 104102:
                    if (qVar instanceof cr) {
                        this.h.closeLoadingDialog();
                        if (((cr) qVar).k()) {
                            this.h.showToast(((cr) qVar).m());
                        }
                    }
                    if (qVar instanceof co) {
                        co coVar = (co) qVar;
                        if (coVar.n() instanceof bd) {
                            bd bdVar = (bd) coVar.n();
                            if (bdVar.b() == 10) {
                                this.e = bdVar.c() == 1;
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
                    if ((qVar instanceof cr) && ((cr) qVar).k()) {
                        this.h.hideProgressBar();
                        this.h.showToast(((cr) qVar).m());
                        return;
                    } else if (qVar instanceof ce) {
                        ce ceVar = (ce) qVar;
                        if (ceVar.a() != null) {
                            this.c = ceVar.a();
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
