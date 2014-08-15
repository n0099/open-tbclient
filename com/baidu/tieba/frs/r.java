package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        cu cuVar4;
        cu cuVar5;
        cu cuVar6;
        cu cuVar7;
        cu cuVar8;
        cu cuVar9;
        cu cuVar10;
        cu cuVar11;
        String str;
        bb bbVar;
        bb bbVar2;
        cu cuVar12;
        g gVar;
        String str2;
        cu cuVar13;
        cu cuVar14;
        boolean z;
        cu cuVar15;
        cu cuVar16;
        cu cuVar17;
        boolean z2;
        cu cuVar18;
        cu cuVar19;
        cu cuVar20;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        g gVar8;
        cu cuVar21;
        cu cuVar22;
        boolean z3;
        cu cuVar23;
        String str3;
        String str4;
        cu cuVar24;
        cu cuVar25;
        g gVar9;
        g gVar10;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        g gVar15;
        g gVar16;
        g gVar17;
        String str5;
        cu cuVar26;
        cu cuVar27;
        g gVar18;
        String str6;
        g gVar19;
        g gVar20;
        cu cuVar28;
        cu cuVar29;
        String str7;
        cu cuVar30;
        cu cuVar31;
        cu cuVar32;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
        cuVar = this.a.z;
        if (view != cuVar.j()) {
            cuVar2 = this.a.z;
            if (view != cuVar2.e()) {
                cuVar3 = this.a.z;
                if (view != cuVar3.l()) {
                    cuVar4 = this.a.z;
                    if (view != cuVar4.k()) {
                        cuVar5 = this.a.z;
                        if (view == cuVar5.f()) {
                            cuVar16 = this.a.z;
                            cuVar16.b();
                            cuVar17 = this.a.z;
                            if (cuVar17.o().isMenuShowing()) {
                                cuVar18 = this.a.z;
                                cuVar18.o().toggle(true);
                            }
                            z2 = this.a.H;
                            if (z2) {
                                this.a.H = false;
                                this.a.D();
                            }
                        } else {
                            cuVar6 = this.a.z;
                            if (view != cuVar6.g()) {
                                cuVar7 = this.a.z;
                                if (view != cuVar7.h()) {
                                    cuVar8 = this.a.z;
                                    if (view != cuVar8.i()) {
                                        cuVar9 = this.a.z;
                                        FrsHeaderView w = cuVar9.w();
                                        cuVar10 = this.a.z;
                                        com.baidu.tieba.frs.view.n x = cuVar10.x();
                                        if ((w != null && w.a(view)) || (x != null && x.a(view))) {
                                            com.baidu.tbadk.core.f.a(this.a.getParent(), "forum_fortune_click");
                                            if (!TbadkApplication.isLogin()) {
                                                LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                                            } else {
                                                this.a.I();
                                            }
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                        cuVar11 = this.a.z;
                                        cuVar11.b();
                                        FrsActivity frsActivity = this.a;
                                        FrsActivity frsActivity2 = this.a;
                                        str = this.a.q;
                                        frsActivity.Z = new bb(frsActivity2, str);
                                        bbVar = this.a.Z;
                                        bbVar.setSelfExecute(true);
                                        bbVar2 = this.a.Z;
                                        bbVar2.execute(new String[0]);
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.a, "frs_image_threads", "frsclick", 1, new Object[0]);
                                    cuVar12 = this.a.z;
                                    cuVar12.b();
                                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                                    gVar = this.a.L;
                                    m252getInst.addFrsImageForum(gVar.i().getName());
                                    FrsActivity frsActivity3 = this.a;
                                    com.baidu.tbadk.core.atomData.s sVar = new com.baidu.tbadk.core.atomData.s(this.a);
                                    str2 = this.a.q;
                                    frsActivity3.sendMessage(new CustomMessage(2003002, sVar.b(str2, null, 0)));
                                    this.a.g();
                                }
                            } else {
                                TiebaStatic.eventStat(this.a, "frs_good_threads", "frsclick", 1, new Object[0]);
                                cuVar13 = this.a.z;
                                cuVar13.b();
                                cuVar14 = this.a.z;
                                if (cuVar14.o().isMenuShowing()) {
                                    cuVar15 = this.a.z;
                                    cuVar15.o().toggle(true);
                                }
                                z = this.a.H;
                                if (!z) {
                                    this.a.H = true;
                                    this.a.D();
                                }
                            }
                        }
                    } else {
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        cuVar19 = this.a.z;
                        cuVar19.Q();
                        FrsActivity.l = false;
                        cuVar20 = this.a.z;
                        cuVar20.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            } else {
                this.a.H();
                TiebaStatic.eventStat(this.a, "frs_forum_name", "frsclick", 1, new Object[0]);
            }
        } else {
            TiebaStatic.eventStat(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.u.frs_bt_create) {
            this.a.C();
        } else if (id == com.baidu.tieba.u.btn_love) {
            cuVar32 = this.a.z;
            if (!cuVar32.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.i();
            }
        } else if (id == com.baidu.tieba.u.btn_sign) {
            cuVar30 = this.a.z;
            if (!cuVar30.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                cuVar31 = this.a.z;
                if (!cuVar31.F()) {
                    this.a.k();
                }
            }
        } else if (id == com.baidu.tieba.u.add_fan) {
            cuVar29 = this.a.z;
            if (!cuVar29.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                f a = f.a();
                str7 = this.a.q;
                a.a(str7, false);
                this.a.h();
            }
        } else if (id == com.baidu.tieba.u.refresh_layout) {
            TiebaStatic.eventStat(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            cuVar28 = this.a.z;
            cuVar28.S();
        } else if (id == com.baidu.tieba.u.message_layout) {
            FrsActivity.l = false;
            FrsActivity.m = false;
            this.a.f();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.h(this.a)));
            }
        } else if (id == com.baidu.tieba.u.mention_layout) {
            FrsActivity.l = false;
            FrsActivity.n = false;
            this.a.f();
            String currentAccount2 = TbadkApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bw((Context) this.a, false)));
            }
        } else if (id == com.baidu.tieba.u.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bc(this.a)));
        } else if (id == com.baidu.tieba.u.forum_manager_center) {
            String str8 = "";
            gVar18 = this.a.L;
            if (gVar18 != null) {
                gVar19 = this.a.L;
                if (gVar19.i() != null) {
                    gVar20 = this.a.L;
                    str8 = gVar20.i().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str6 = this.a.q;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str6).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.u.recommend_forum_item_layout) {
            dw dwVar = (dw) view.getTag();
            if (dwVar != null) {
                String str9 = dwVar.a;
                str5 = this.a.q;
                if (str9.equals(str5)) {
                    cuVar26 = this.a.z;
                    if (cuVar26.o().isMenuShowing()) {
                        cuVar27 = this.a.z;
                        cuVar27.o().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.A = "sidebar";
                this.a.B = dwVar.b;
                this.a.c(str9);
            }
        } else if (id == com.baidu.tieba.u.frs_header_groups) {
            gVar12 = this.a.L;
            if (gVar12 != null) {
                gVar13 = this.a.L;
                if (gVar13.i() != null) {
                    gVar14 = this.a.L;
                    if (!com.baidu.adp.lib.util.i.c(gVar14.i().getId())) {
                        gVar15 = this.a.L;
                        if (gVar15.r() != null) {
                            TiebaStatic.eventStat(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity4 = this.a;
                            gVar16 = this.a.L;
                            String id2 = gVar16.i().getId();
                            gVar17 = this.a.L;
                            this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.t(frsActivity4, id2, gVar17.r().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.u.frs_header_games) {
            TiebaStatic.eventStat(this.a, "frs_ourgame", "click", 1, new Object[0]);
            gVar9 = this.a.L;
            if (gVar9 != null) {
                gVar10 = this.a.L;
                if (gVar10.b() != null) {
                    gVar11 = this.a.L;
                    String b = gVar11.b();
                    int a2 = com.baidu.tbadk.a.a.a(b);
                    if (a2 == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cb(this.a, null, b, true)));
                    } else if (a2 == 1) {
                        String b2 = com.baidu.tbadk.a.a.b(b);
                        if (!TextUtils.isEmpty(b2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(this.a, b2)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.u.btn_love_content) {
            cuVar22 = this.a.z;
            if (!cuVar22.u()) {
                z3 = this.a.W;
                if (!z3) {
                    cuVar23 = this.a.z;
                    if (cuVar23 != null) {
                        str3 = this.a.R;
                        if (str3.equals("normal_page")) {
                            cuVar25 = this.a.z;
                            cuVar25.a(view);
                            return;
                        }
                        str4 = this.a.R;
                        if (str4.equals("frs_page")) {
                            cuVar24 = this.a.z;
                            cuVar24.b(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.u.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            cuVar21 = this.a.z;
            cuVar21.R();
        } else if (id == com.baidu.tieba.u.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                gVar2 = this.a.L;
                if (gVar2 != null) {
                    gVar3 = this.a.L;
                    if (gVar3.i() != null) {
                        gVar4 = this.a.L;
                        if (gVar4.i().getAnchorPower() != null) {
                            gVar5 = this.a.L;
                            if (gVar5.i().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.f.a(this.a.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.a;
                                gVar7 = this.a.L;
                                int a3 = com.baidu.adp.lib.e.b.a(gVar7.i().getId(), 0);
                                gVar8 = this.a.L;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.am(frsActivity5, a3, gVar8.i().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.a;
                            gVar6 = this.a.L;
                            frsActivity6.showToast(gVar6.i().getAnchorPower().anchor_message);
                            return;
                        }
                        this.a.showToast(com.baidu.tieba.x.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.x.live_error_system_not_support);
        }
    }
}
