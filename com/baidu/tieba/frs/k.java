package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsHeaderView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        bs bsVar10;
        boolean z;
        bs bsVar11;
        String str;
        String str2;
        bs bsVar12;
        bs bsVar13;
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        com.baidu.tieba.model.z zVar6;
        com.baidu.tieba.model.z zVar7;
        String str3;
        bs bsVar14;
        boolean z2;
        bs bsVar15;
        bs bsVar16;
        bs bsVar17;
        bs bsVar18;
        boolean z3;
        bs bsVar19;
        com.baidu.tieba.model.z zVar8;
        String str4;
        com.baidu.tieba.model.z zVar9;
        com.baidu.tieba.model.z zVar10;
        String str5;
        aj ajVar;
        aj ajVar2;
        String str6;
        bs bsVar20;
        bs bsVar21;
        bs bsVar22;
        bs bsVar23;
        String str7;
        bs bsVar24;
        bs bsVar25;
        bs bsVar26;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(this.a);
        bsVar = this.a.p;
        if (view != bsVar.c()) {
            bsVar2 = this.a.p;
            if (view == bsVar2.a()) {
                bsVar8 = this.a.p;
                bsVar8.d(0);
            } else {
                bsVar3 = this.a.p;
                if (view != bsVar3.b()) {
                    bsVar4 = this.a.p;
                    if (view != bsVar4.d()) {
                        bsVar5 = this.a.p;
                        FrsHeaderView n = bsVar5.n();
                        bsVar6 = this.a.p;
                        com.baidu.tieba.view.ar o = bsVar6.o();
                        if ((n != null && n.b(view)) || (o != null && o.b(view))) {
                            com.baidu.tieba.ai.a(this.a.getParent(), "forum_fortune_click");
                            if (!TiebaApplication.w()) {
                                LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                            } else {
                                this.a.q();
                            }
                        }
                    } else {
                        com.baidu.tieba.util.cb.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        bsVar7 = this.a.p;
                        bsVar7.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            }
        } else {
            com.baidu.tieba.util.cb.a(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        int id = view.getId();
        if (id == R.id.frs_bt_create) {
            this.a.m();
        } else if (id == R.id.btn_love) {
            bsVar26 = this.a.p;
            if (!bsVar26.l() && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.j();
            }
        } else if (id == R.id.btn_sign) {
            bsVar24 = this.a.p;
            if (!bsVar24.l() && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
                bsVar25 = this.a.p;
                if (!bsVar25.x()) {
                    this.a.k();
                }
            }
        } else if (id == R.id.add_fan) {
            bsVar23 = this.a.p;
            if (!bsVar23.l() && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
                com.baidu.tieba.model.o a = com.baidu.tieba.model.o.a();
                str7 = this.a.g;
                a.b(str7);
                this.a.i();
            }
        } else if (id == R.id.refresh_layout) {
            com.baidu.tieba.util.cb.a(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            bsVar22 = this.a.p;
            bsVar22.H();
        } else if (id == R.id.message_layout) {
            String v = TiebaApplication.v();
            if (v != null && v.length() > 0) {
                com.baidu.tieba.util.cb.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                com.baidu.tieba.mention.c.a((Activity) this.a, 18002);
            }
        } else if (id == R.id.like_forum_name) {
            com.baidu.tieba.util.cb.a(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str8 = (String) view.getTag();
            str6 = this.a.g;
            if (str8.equals(str6)) {
                this.a.J = false;
                bsVar20 = this.a.p;
                if (bsVar20.g().isMenuShowing()) {
                    bsVar21 = this.a.p;
                    bsVar21.g().toggle(true);
                    return;
                }
                return;
            }
            FrsActivity.f(this.a, str8);
        } else if (id == R.id.add_to_window_layout) {
            FrsActivity frsActivity = this.a;
            FrsActivity frsActivity2 = this.a;
            str5 = this.a.g;
            frsActivity.T = new aj(frsActivity2, str5);
            ajVar = this.a.T;
            ajVar.setSelfExecute(true);
            ajVar2 = this.a.T;
            ajVar2.execute(new String[0]);
        } else if (id == R.id.manage_mode) {
            String str9 = "";
            zVar8 = this.a.A;
            if (zVar8 != null) {
                zVar9 = this.a.A;
                if (zVar9.f() != null) {
                    zVar10 = this.a.A;
                    str9 = zVar10.f().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str4 = this.a.g;
            String sb2 = sb.append(str4).append("&fid=").append(str9).toString();
            com.baidu.tieba.ai.a(this.a.getParent(), "forum_management_click");
            UtilHelper.c(this.a, sb2);
        } else if (id == R.id.show_all) {
            this.a.J = false;
            bsVar17 = this.a.p;
            if (bsVar17.g().isMenuShowing()) {
                bsVar19 = this.a.p;
                bsVar19.g().toggle(true);
            }
            bsVar18 = this.a.p;
            bsVar18.f().a(R.id.show_all);
            z3 = this.a.w;
            if (z3) {
                this.a.w = false;
                this.a.n();
            }
        } else if (id == R.id.show_good) {
            this.a.J = false;
            com.baidu.tieba.util.cb.a(this.a, "frs_good", "frsclick", 1, new Object[0]);
            bsVar14 = this.a.p;
            if (bsVar14.g().isMenuShowing()) {
                bsVar16 = this.a.p;
                bsVar16.g().toggle(true);
            }
            z2 = this.a.w;
            if (!z2) {
                this.a.w = true;
                bsVar15 = this.a.p;
                bsVar15.f().a(R.id.show_good);
                this.a.n();
            }
        } else if (id == R.id.show_image) {
            this.a.J = false;
            com.baidu.tieba.util.cb.a(this.a, "frs_image", "frsclick", 1, new Object[0]);
            TiebaApplication g = TiebaApplication.g();
            zVar7 = this.a.A;
            g.h(zVar7.f().getName());
            FrsActivity frsActivity3 = this.a;
            str3 = this.a.g;
            FrsImageActivity.a(frsActivity3, str3, null, 0);
            this.a.h();
        } else if (id == R.id.frs_header_groups) {
            zVar = this.a.A;
            if (zVar != null) {
                zVar2 = this.a.A;
                if (zVar2.f() != null) {
                    zVar3 = this.a.A;
                    if (!com.baidu.adp.lib.util.g.b(zVar3.f().getId())) {
                        zVar4 = this.a.A;
                        if (zVar4.o() != null) {
                            com.baidu.tieba.util.cb.a(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity4 = this.a;
                            zVar5 = this.a.A;
                            String id2 = zVar5.f().getId();
                            zVar6 = this.a.A;
                            this.a.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tieba.a.a(frsActivity4, id2, zVar6.o().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == R.id.btn_love_content) {
            bsVar10 = this.a.p;
            if (!bsVar10.l()) {
                z = this.a.N;
                if (!z) {
                    bsVar11 = this.a.p;
                    if (bsVar11 != null) {
                        str = this.a.G;
                        if (str.equals("normal_page")) {
                            bsVar13 = this.a.p;
                            bsVar13.a(view);
                            return;
                        }
                        str2 = this.a.G;
                        if (str2.equals("frs_page")) {
                            bsVar12 = this.a.p;
                            bsVar12.b(view);
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
            bsVar9 = this.a.p;
            bsVar9.G();
        }
    }
}
