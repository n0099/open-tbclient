package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* loaded from: classes.dex */
final class r implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        cm cmVar5;
        cm cmVar6;
        cm cmVar7;
        cm cmVar8;
        cm cmVar9;
        cm cmVar10;
        cm cmVar11;
        cm cmVar12;
        String str;
        ax axVar;
        ax axVar2;
        cm cmVar13;
        g gVar;
        String str2;
        cm cmVar14;
        cm cmVar15;
        boolean z;
        cm cmVar16;
        cm cmVar17;
        cm cmVar18;
        boolean z2;
        cm cmVar19;
        cm cmVar20;
        cm cmVar21;
        cm cmVar22;
        boolean z3;
        cm cmVar23;
        String str3;
        String str4;
        cm cmVar24;
        cm cmVar25;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        String str5;
        cm cmVar26;
        cm cmVar27;
        g gVar8;
        String str6;
        g gVar9;
        g gVar10;
        cm cmVar28;
        cm cmVar29;
        String str7;
        cm cmVar30;
        cm cmVar31;
        cm cmVar32;
        UtilHelper.NetworkStateInfo d = UtilHelper.d(this.a);
        cmVar = this.a.r;
        if (view != cmVar.i()) {
            cmVar2 = this.a.r;
            if (view != cmVar2.c()) {
                cmVar3 = this.a.r;
                if (view != cmVar3.h()) {
                    cmVar4 = this.a.r;
                    if (view != cmVar4.k()) {
                        cmVar5 = this.a.r;
                        if (view != cmVar5.j()) {
                            cmVar6 = this.a.r;
                            if (view == cmVar6.d()) {
                                cmVar17 = this.a.r;
                                cmVar17.b();
                                cmVar18 = this.a.r;
                                if (cmVar18.n().isMenuShowing()) {
                                    cmVar19 = this.a.r;
                                    cmVar19.n().toggle(true);
                                }
                                z2 = this.a.z;
                                if (z2) {
                                    this.a.z = false;
                                    this.a.n();
                                }
                            } else {
                                cmVar7 = this.a.r;
                                if (view != cmVar7.e()) {
                                    cmVar8 = this.a.r;
                                    if (view != cmVar8.f()) {
                                        cmVar9 = this.a.r;
                                        if (view != cmVar9.g()) {
                                            cmVar10 = this.a.r;
                                            FrsHeaderView u = cmVar10.u();
                                            cmVar11 = this.a.r;
                                            com.baidu.tieba.frs.view.n v = cmVar11.v();
                                            if ((u != null && u.b(view)) || (v != null && v.b(view))) {
                                                com.baidu.tbadk.core.g.a(this.a.getParent(), "forum_fortune_click");
                                                if (!TbadkApplication.F()) {
                                                    LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                                                } else {
                                                    this.a.q();
                                                }
                                            }
                                        } else {
                                            TiebaStatic.a(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                            cmVar12 = this.a.r;
                                            cmVar12.b();
                                            FrsActivity frsActivity = this.a;
                                            FrsActivity frsActivity2 = this.a;
                                            str = this.a.i;
                                            frsActivity.R = new ax(frsActivity2, str);
                                            axVar = this.a.R;
                                            axVar.setSelfExecute(true);
                                            axVar2 = this.a.R;
                                            axVar2.execute(new String[0]);
                                        }
                                    } else {
                                        TiebaStatic.a(this.a, "frs_image_threads", "frsclick", 1, new Object[0]);
                                        cmVar13 = this.a.r;
                                        cmVar13.b();
                                        TbadkApplication j = TbadkApplication.j();
                                        gVar = this.a.D;
                                        j.n(gVar.f().getName());
                                        FrsActivity frsActivity3 = this.a;
                                        com.baidu.tbadk.core.b.l lVar = new com.baidu.tbadk.core.b.l(this.a);
                                        str2 = this.a.i;
                                        frsActivity3.sendMessage(new com.baidu.adp.framework.message.a(2003002, lVar.b(str2, null, 0)));
                                        this.a.h();
                                    }
                                } else {
                                    TiebaStatic.a(this.a, "frs_good_threads", "frsclick", 1, new Object[0]);
                                    cmVar14 = this.a.r;
                                    cmVar14.b();
                                    cmVar15 = this.a.r;
                                    if (cmVar15.n().isMenuShowing()) {
                                        cmVar16 = this.a.r;
                                        cmVar16.n().toggle(true);
                                    }
                                    z = this.a.z;
                                    if (!z) {
                                        this.a.z = true;
                                        this.a.n();
                                    }
                                }
                            }
                        } else {
                            TiebaStatic.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                            cmVar20 = this.a.r;
                            cmVar20.a(true);
                        }
                    } else {
                        this.a.closeActivity();
                    }
                } else {
                    this.a.closeActivity();
                }
            } else {
                this.a.r.a();
                TiebaStatic.a(this.a, "frs_forum_name", "frsclick", 1, new Object[0]);
            }
        } else {
            TiebaStatic.a(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.frs_bt_create) {
            this.a.m();
        } else if (id == com.baidu.tieba.a.h.btn_love) {
            cmVar32 = this.a.r;
            if (!cmVar32.s() && d != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.j();
            }
        } else if (id == com.baidu.tieba.a.h.btn_sign) {
            cmVar30 = this.a.r;
            if (!cmVar30.s() && d != UtilHelper.NetworkStateInfo.UNAVAIL) {
                cmVar31 = this.a.r;
                if (!cmVar31.E()) {
                    this.a.k();
                }
            }
        } else if (id == com.baidu.tieba.a.h.add_fan) {
            cmVar29 = this.a.r;
            if (!cmVar29.s() && d != UtilHelper.NetworkStateInfo.UNAVAIL) {
                f a = f.a();
                str7 = this.a.i;
                a.b(str7);
                this.a.i();
            }
        } else if (id == com.baidu.tieba.a.h.refresh_layout) {
            TiebaStatic.a(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            cmVar28 = this.a.r;
            cmVar28.O();
        } else if (id == com.baidu.tieba.a.h.message_layout) {
            String E = TbadkApplication.E();
            if (E != null && E.length() > 0) {
                TiebaStatic.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new com.baidu.adp.framework.message.a(2015003, new com.baidu.tbadk.core.frameworkData.a(this.a)));
            }
        } else if (id == com.baidu.tieba.a.h.forum_manager_center) {
            String str8 = "";
            gVar8 = this.a.D;
            if (gVar8 != null) {
                gVar9 = this.a.D;
                if (gVar9.f() != null) {
                    gVar10 = this.a.D;
                    str8 = gVar10.f().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str6 = this.a.i;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str6).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.a.h.recommend_forum_item_layout) {
            di diVar = (di) view.getTag();
            if (diVar != null) {
                String str9 = diVar.a;
                TiebaStatic.a(this.a, "sidebar_show", "sidebar_click", 1, "st_param", diVar.b);
                str5 = this.a.i;
                if (str9.equals(str5)) {
                    cmVar26 = this.a.r;
                    if (cmVar26.n().isMenuShowing()) {
                        cmVar27 = this.a.r;
                        cmVar27.n().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.s = "sidebar";
                this.a.t = diVar.b;
                FrsActivity.g(this.a, str9);
            }
        } else if (id == com.baidu.tieba.a.h.frs_header_groups) {
            gVar2 = this.a.D;
            if (gVar2 != null) {
                gVar3 = this.a.D;
                if (gVar3.f() != null) {
                    gVar4 = this.a.D;
                    if (!com.baidu.adp.lib.util.h.b(gVar4.f().getId())) {
                        gVar5 = this.a.D;
                        if (gVar5.o() != null) {
                            TiebaStatic.a(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity4 = this.a;
                            gVar6 = this.a.D;
                            String id2 = gVar6.f().getId();
                            gVar7 = this.a.D;
                            this.a.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.m(frsActivity4, id2, gVar7.o().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.a.h.btn_love_content) {
            cmVar22 = this.a.r;
            if (!cmVar22.s()) {
                z3 = this.a.N;
                if (!z3) {
                    cmVar23 = this.a.r;
                    if (cmVar23 != null) {
                        str3 = this.a.J;
                        if (str3.equals("normal_page")) {
                            cmVar25 = this.a.r;
                            cmVar25.a(view);
                            return;
                        }
                        str4 = this.a.J;
                        if (str4.equals("frs_page")) {
                            cmVar24 = this.a.r;
                            cmVar24.b(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.a.h.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            cmVar21 = this.a.r;
            cmVar21.N();
        }
    }
}
