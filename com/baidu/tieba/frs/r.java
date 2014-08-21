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
        cv cvVar;
        cv cvVar2;
        cv cvVar3;
        cv cvVar4;
        cv cvVar5;
        cv cvVar6;
        cv cvVar7;
        cv cvVar8;
        cv cvVar9;
        cv cvVar10;
        cv cvVar11;
        String str;
        bc bcVar;
        bc bcVar2;
        cv cvVar12;
        g gVar;
        String str2;
        cv cvVar13;
        cv cvVar14;
        boolean z;
        cv cvVar15;
        cv cvVar16;
        cv cvVar17;
        boolean z2;
        cv cvVar18;
        cv cvVar19;
        cv cvVar20;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        g gVar8;
        cv cvVar21;
        cv cvVar22;
        boolean z3;
        cv cvVar23;
        String str3;
        String str4;
        cv cvVar24;
        cv cvVar25;
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
        cv cvVar26;
        cv cvVar27;
        g gVar18;
        String str6;
        g gVar19;
        g gVar20;
        cv cvVar28;
        cv cvVar29;
        String str7;
        cv cvVar30;
        cv cvVar31;
        cv cvVar32;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
        cvVar = this.a.B;
        if (view != cvVar.j()) {
            cvVar2 = this.a.B;
            if (view != cvVar2.e()) {
                cvVar3 = this.a.B;
                if (view != cvVar3.l()) {
                    cvVar4 = this.a.B;
                    if (view != cvVar4.k()) {
                        cvVar5 = this.a.B;
                        if (view == cvVar5.f()) {
                            cvVar16 = this.a.B;
                            cvVar16.b();
                            cvVar17 = this.a.B;
                            if (cvVar17.o().isMenuShowing()) {
                                cvVar18 = this.a.B;
                                cvVar18.o().toggle(true);
                            }
                            z2 = this.a.J;
                            if (z2) {
                                this.a.J = false;
                                this.a.E();
                            }
                        } else {
                            cvVar6 = this.a.B;
                            if (view != cvVar6.g()) {
                                cvVar7 = this.a.B;
                                if (view != cvVar7.h()) {
                                    cvVar8 = this.a.B;
                                    if (view != cvVar8.i()) {
                                        cvVar9 = this.a.B;
                                        FrsHeaderView w = cvVar9.w();
                                        cvVar10 = this.a.B;
                                        com.baidu.tieba.frs.view.n x = cvVar10.x();
                                        if ((w != null && w.a(view)) || (x != null && x.a(view))) {
                                            com.baidu.tbadk.core.f.a(this.a.getParent(), "forum_fortune_click");
                                            if (!TbadkApplication.isLogin()) {
                                                LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                                            } else {
                                                this.a.J();
                                            }
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                        cvVar11 = this.a.B;
                                        cvVar11.b();
                                        FrsActivity frsActivity = this.a;
                                        FrsActivity frsActivity2 = this.a;
                                        str = this.a.q;
                                        frsActivity.ab = new bc(frsActivity2, str);
                                        bcVar = this.a.ab;
                                        bcVar.setSelfExecute(true);
                                        bcVar2 = this.a.ab;
                                        bcVar2.execute(new String[0]);
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.a, "frs_image_threads", "frsclick", 1, new Object[0]);
                                    cvVar12 = this.a.B;
                                    cvVar12.b();
                                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                                    gVar = this.a.N;
                                    m252getInst.addFrsImageForum(gVar.i().getName());
                                    FrsActivity frsActivity3 = this.a;
                                    com.baidu.tbadk.core.atomData.s sVar = new com.baidu.tbadk.core.atomData.s(this.a);
                                    str2 = this.a.q;
                                    frsActivity3.sendMessage(new CustomMessage(2003002, sVar.b(str2, null, 0)));
                                    this.a.g();
                                }
                            } else {
                                TiebaStatic.eventStat(this.a, "frs_good_threads", "frsclick", 1, new Object[0]);
                                cvVar13 = this.a.B;
                                cvVar13.b();
                                cvVar14 = this.a.B;
                                if (cvVar14.o().isMenuShowing()) {
                                    cvVar15 = this.a.B;
                                    cvVar15.o().toggle(true);
                                }
                                z = this.a.J;
                                if (!z) {
                                    this.a.J = true;
                                    this.a.E();
                                }
                            }
                        }
                    } else {
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        cvVar19 = this.a.B;
                        cvVar19.Q();
                        FrsActivity.l = false;
                        cvVar20 = this.a.B;
                        cvVar20.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            } else {
                this.a.I();
                TiebaStatic.eventStat(this.a, "frs_forum_name", "frsclick", 1, new Object[0]);
            }
        } else {
            TiebaStatic.eventStat(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.u.frs_bt_create) {
            this.a.D();
        } else if (id == com.baidu.tieba.u.btn_love) {
            cvVar32 = this.a.B;
            if (!cvVar32.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.i();
            }
        } else if (id == com.baidu.tieba.u.btn_sign) {
            cvVar30 = this.a.B;
            if (!cvVar30.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                cvVar31 = this.a.B;
                if (!cvVar31.F()) {
                    this.a.k();
                }
            }
        } else if (id == com.baidu.tieba.u.add_fan) {
            cvVar29 = this.a.B;
            if (!cvVar29.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                f a = f.a();
                str7 = this.a.q;
                a.a(str7, false);
                this.a.h();
            }
        } else if (id == com.baidu.tieba.u.refresh_layout) {
            TiebaStatic.eventStat(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            cvVar28 = this.a.B;
            cvVar28.S();
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
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bx((Context) this.a, false)));
            }
        } else if (id == com.baidu.tieba.u.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bd(this.a)));
        } else if (id == com.baidu.tieba.u.forum_manager_center) {
            String str8 = "";
            gVar18 = this.a.N;
            if (gVar18 != null) {
                gVar19 = this.a.N;
                if (gVar19.i() != null) {
                    gVar20 = this.a.N;
                    str8 = gVar20.i().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str6 = this.a.q;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str6).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.u.recommend_forum_item_layout) {
            dy dyVar = (dy) view.getTag();
            if (dyVar != null) {
                String str9 = dyVar.a;
                str5 = this.a.q;
                if (str9.equals(str5)) {
                    cvVar26 = this.a.B;
                    if (cvVar26.o().isMenuShowing()) {
                        cvVar27 = this.a.B;
                        cvVar27.o().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.C = "sidebar";
                this.a.D = dyVar.b;
                this.a.c(str9);
            }
        } else if (id == com.baidu.tieba.u.frs_header_groups) {
            gVar12 = this.a.N;
            if (gVar12 != null) {
                gVar13 = this.a.N;
                if (gVar13.i() != null) {
                    gVar14 = this.a.N;
                    if (!com.baidu.adp.lib.util.i.c(gVar14.i().getId())) {
                        gVar15 = this.a.N;
                        if (gVar15.r() != null) {
                            TiebaStatic.eventStat(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity4 = this.a;
                            gVar16 = this.a.N;
                            String id2 = gVar16.i().getId();
                            gVar17 = this.a.N;
                            this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.t(frsActivity4, id2, gVar17.r().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.u.frs_header_games) {
            TiebaStatic.eventStat(this.a, "frs_ourgame", "click", 1, new Object[0]);
            gVar9 = this.a.N;
            if (gVar9 != null) {
                gVar10 = this.a.N;
                if (gVar10.b() != null) {
                    gVar11 = this.a.N;
                    String b = gVar11.b();
                    int a2 = com.baidu.tbadk.game.a.a(b);
                    if (a2 == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cc(this.a, null, b, true)));
                    } else if (a2 == 1) {
                        String b2 = com.baidu.tbadk.game.a.b(b);
                        if (!TextUtils.isEmpty(b2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.w(this.a, b2)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.u.btn_love_content) {
            cvVar22 = this.a.B;
            if (!cvVar22.u()) {
                z3 = this.a.Y;
                if (!z3) {
                    cvVar23 = this.a.B;
                    if (cvVar23 != null) {
                        str3 = this.a.T;
                        if (str3.equals("normal_page")) {
                            cvVar25 = this.a.B;
                            cvVar25.a(view);
                            return;
                        }
                        str4 = this.a.T;
                        if (str4.equals("frs_page")) {
                            cvVar24 = this.a.B;
                            cvVar24.b(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.u.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            cvVar21 = this.a.B;
            cvVar21.R();
        } else if (id == com.baidu.tieba.u.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                gVar2 = this.a.N;
                if (gVar2 != null) {
                    gVar3 = this.a.N;
                    if (gVar3.i() != null) {
                        gVar4 = this.a.N;
                        if (gVar4.i().getAnchorPower() != null) {
                            gVar5 = this.a.N;
                            if (gVar5.i().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.f.a(this.a.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.a;
                                gVar7 = this.a.N;
                                int a3 = com.baidu.adp.lib.e.c.a(gVar7.i().getId(), 0);
                                gVar8 = this.a.N;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.an(frsActivity5, a3, gVar8.i().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.a;
                            gVar6 = this.a.N;
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
