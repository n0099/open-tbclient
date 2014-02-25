package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.FrsHeaderView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar;
        br brVar2;
        br brVar3;
        br brVar4;
        br brVar5;
        br brVar6;
        br brVar7;
        br brVar8;
        br brVar9;
        br brVar10;
        boolean z;
        br brVar11;
        String str;
        String str2;
        br brVar12;
        br brVar13;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        com.baidu.tieba.model.z zVar6;
        com.baidu.tieba.model.z zVar7;
        String str3;
        br brVar14;
        boolean z2;
        br brVar15;
        br brVar16;
        br brVar17;
        br brVar18;
        boolean z3;
        br brVar19;
        com.baidu.tieba.model.z zVar8;
        String str4;
        com.baidu.tieba.model.z zVar9;
        com.baidu.tieba.model.z zVar10;
        String str5;
        String str6;
        br brVar20;
        br brVar21;
        br brVar22;
        br brVar23;
        String str7;
        br brVar24;
        br brVar25;
        br brVar26;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(this.a);
        brVar = this.a.p;
        if (view != brVar.c()) {
            brVar2 = this.a.p;
            if (view == brVar2.a()) {
                brVar8 = this.a.p;
                brVar8.d(0);
            } else {
                brVar3 = this.a.p;
                if (view != brVar3.b()) {
                    brVar4 = this.a.p;
                    if (view != brVar4.d()) {
                        brVar5 = this.a.p;
                        FrsHeaderView o = brVar5.o();
                        brVar6 = this.a.p;
                        com.baidu.tieba.view.ar p = brVar6.p();
                        if ((o != null && o.b(view)) || (p != null && p.b(view))) {
                            com.baidu.tieba.ai.a(this.a.getParent(), "forum_fortune_click");
                            if (!TiebaApplication.B()) {
                                LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                            } else {
                                this.a.H();
                            }
                        }
                    } else {
                        cb.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        brVar7 = this.a.p;
                        brVar7.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            }
        } else {
            cb.a(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        int id = view.getId();
        if (id == R.id.frs_bt_create) {
            this.a.B();
        } else if (id == R.id.btn_love) {
            brVar26 = this.a.p;
            if (!brVar26.m() && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.j();
            }
        } else if (id == R.id.btn_sign) {
            brVar24 = this.a.p;
            if (!brVar24.m() && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
                brVar25 = this.a.p;
                if (!brVar25.z()) {
                    this.a.l();
                }
            }
        } else if (id == R.id.add_fan) {
            brVar23 = this.a.p;
            if (!brVar23.m() && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
                com.baidu.tieba.model.o a = com.baidu.tieba.model.o.a();
                str7 = this.a.g;
                a.b(str7);
                this.a.i();
            }
        } else if (id == R.id.refresh_layout) {
            cb.a(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            brVar22 = this.a.p;
            brVar22.J();
        } else if (id == R.id.message_layout) {
            String A = TiebaApplication.A();
            if (A != null && A.length() > 0) {
                cb.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                com.baidu.tieba.mention.c.a((Activity) this.a, 18002);
            }
        } else if (id == R.id.like_forum_name) {
            cb.a(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str8 = (String) view.getTag();
            str6 = this.a.g;
            if (str8.equals(str6)) {
                this.a.J = false;
                brVar20 = this.a.p;
                if (brVar20.g().isMenuShowing()) {
                    brVar21 = this.a.p;
                    brVar21.g().toggle(true);
                    return;
                }
                return;
            }
            this.a.b(str8);
        } else if (id == R.id.add_to_window_layout) {
            FrsActivity frsActivity = this.a;
            str5 = this.a.g;
            frsActivity.a(str5);
        } else if (id == R.id.manage_mode) {
            String str9 = "";
            zVar8 = this.a.A;
            if (zVar8 != null) {
                zVar9 = this.a.A;
                if (zVar9.b() != null) {
                    zVar10 = this.a.A;
                    str9 = zVar10.b().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str4 = this.a.g;
            String sb2 = sb.append(str4).append("&fid=").append(str9).toString();
            com.baidu.tieba.ai.a(this.a.getParent(), "forum_management_click");
            UtilHelper.c(this.a, sb2);
        } else if (id == R.id.show_all) {
            this.a.J = false;
            brVar17 = this.a.p;
            if (brVar17.g().isMenuShowing()) {
                brVar19 = this.a.p;
                brVar19.g().toggle(true);
            }
            brVar18 = this.a.p;
            brVar18.f().a(R.id.show_all);
            z3 = this.a.w;
            if (z3) {
                this.a.w = false;
                this.a.C();
            }
        } else if (id == R.id.show_good) {
            this.a.J = false;
            cb.a(this.a, "frs_good", "frsclick", 1, new Object[0]);
            brVar14 = this.a.p;
            if (brVar14.g().isMenuShowing()) {
                brVar16 = this.a.p;
                brVar16.g().toggle(true);
            }
            z2 = this.a.w;
            if (!z2) {
                this.a.w = true;
                brVar15 = this.a.p;
                brVar15.f().a(R.id.show_good);
                this.a.C();
            }
        } else if (id == R.id.show_image) {
            this.a.J = false;
            cb.a(this.a, "frs_image", "frsclick", 1, new Object[0]);
            TiebaApplication g = TiebaApplication.g();
            zVar7 = this.a.A;
            g.h(zVar7.b().getName());
            FrsActivity frsActivity2 = this.a;
            str3 = this.a.g;
            FrsImageActivity.a(frsActivity2, str3, null, 0);
            this.a.g();
        } else if (id == R.id.frs_header_groups) {
            zVar = this.a.A;
            if (zVar != null) {
                zVar2 = this.a.A;
                if (zVar2.b() != null) {
                    zVar3 = this.a.A;
                    if (!com.baidu.adp.lib.util.h.b(zVar3.b().getId())) {
                        zVar4 = this.a.A;
                        if (zVar4.k() != null) {
                            cb.a(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity3 = this.a;
                            zVar5 = this.a.A;
                            String id2 = zVar5.b().getId();
                            zVar6 = this.a.A;
                            this.a.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tieba.a.a(frsActivity3, id2, zVar6.k().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == R.id.btn_love_content) {
            brVar10 = this.a.p;
            if (!brVar10.m()) {
                z = this.a.N;
                if (!z) {
                    brVar11 = this.a.p;
                    if (brVar11 != null) {
                        str = this.a.G;
                        if (str.equals("normal_page")) {
                            brVar13 = this.a.p;
                            brVar13.a(view);
                            return;
                        }
                        str2 = this.a.G;
                        if (str2.equals("frs_page")) {
                            brVar12 = this.a.p;
                            brVar12.b(view);
                        }
                    }
                }
            }
        } else if (id == R.id.account_manager_layout) {
            AccountActivity.a(this.a);
        } else if (id == R.id.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            brVar9 = this.a.p;
            brVar9.I();
        }
    }
}
