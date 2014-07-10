package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
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
class q implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        ct ctVar5;
        ct ctVar6;
        ct ctVar7;
        ct ctVar8;
        ct ctVar9;
        ct ctVar10;
        ct ctVar11;
        String str;
        ay ayVar;
        ay ayVar2;
        ct ctVar12;
        g gVar;
        String str2;
        ct ctVar13;
        ct ctVar14;
        boolean z;
        ct ctVar15;
        ct ctVar16;
        ct ctVar17;
        boolean z2;
        ct ctVar18;
        ct ctVar19;
        ct ctVar20;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        g gVar8;
        ct ctVar21;
        ct ctVar22;
        boolean z3;
        ct ctVar23;
        String str3;
        String str4;
        ct ctVar24;
        ct ctVar25;
        g gVar9;
        g gVar10;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        String str5;
        ct ctVar26;
        ct ctVar27;
        g gVar15;
        String str6;
        g gVar16;
        g gVar17;
        Context context;
        ct ctVar28;
        ct ctVar29;
        String str7;
        ct ctVar30;
        ct ctVar31;
        ct ctVar32;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
        ctVar = this.a.v;
        if (view != ctVar.i()) {
            ctVar2 = this.a.v;
            if (view != ctVar2.d()) {
                ctVar3 = this.a.v;
                if (view != ctVar3.k()) {
                    ctVar4 = this.a.v;
                    if (view != ctVar4.j()) {
                        ctVar5 = this.a.v;
                        if (view == ctVar5.e()) {
                            ctVar16 = this.a.v;
                            ctVar16.b();
                            ctVar17 = this.a.v;
                            if (ctVar17.n().isMenuShowing()) {
                                ctVar18 = this.a.v;
                                ctVar18.n().toggle(true);
                            }
                            z2 = this.a.D;
                            if (z2) {
                                this.a.D = false;
                                this.a.E();
                            }
                        } else {
                            ctVar6 = this.a.v;
                            if (view != ctVar6.f()) {
                                ctVar7 = this.a.v;
                                if (view != ctVar7.g()) {
                                    ctVar8 = this.a.v;
                                    if (view != ctVar8.h()) {
                                        ctVar9 = this.a.v;
                                        FrsHeaderView v = ctVar9.v();
                                        ctVar10 = this.a.v;
                                        com.baidu.tieba.frs.view.j w = ctVar10.w();
                                        if ((v != null && v.b(view)) || (w != null && w.b(view))) {
                                            com.baidu.tbadk.core.f.a(this.a.getParent(), "forum_fortune_click");
                                            if (!TbadkApplication.isLogin()) {
                                                LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                                            } else {
                                                this.a.K();
                                            }
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                        ctVar11 = this.a.v;
                                        ctVar11.b();
                                        FrsActivity frsActivity = this.a;
                                        FrsActivity frsActivity2 = this.a;
                                        str = this.a.m;
                                        frsActivity.W = new ay(frsActivity2, str);
                                        ayVar = this.a.W;
                                        ayVar.setSelfExecute(true);
                                        ayVar2 = this.a.W;
                                        ayVar2.execute(new String[0]);
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.a, "frs_image_threads", "frsclick", 1, new Object[0]);
                                    ctVar12 = this.a.v;
                                    ctVar12.b();
                                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                                    gVar = this.a.H;
                                    m252getInst.addFrsImageForum(gVar.g().getName());
                                    FrsActivity frsActivity3 = this.a;
                                    com.baidu.tbadk.core.atomData.r rVar = new com.baidu.tbadk.core.atomData.r(this.a);
                                    str2 = this.a.m;
                                    frsActivity3.sendMessage(new CustomMessage(2003002, rVar.b(str2, null, 0)));
                                    this.a.h();
                                }
                            } else {
                                TiebaStatic.eventStat(this.a, "frs_good_threads", "frsclick", 1, new Object[0]);
                                ctVar13 = this.a.v;
                                ctVar13.b();
                                ctVar14 = this.a.v;
                                if (ctVar14.n().isMenuShowing()) {
                                    ctVar15 = this.a.v;
                                    ctVar15.n().toggle(true);
                                }
                                z = this.a.D;
                                if (!z) {
                                    this.a.D = true;
                                    this.a.E();
                                }
                            }
                        }
                    } else {
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        ctVar19 = this.a.v;
                        ctVar19.P();
                        FrsActivity.b = false;
                        ctVar20 = this.a.v;
                        ctVar20.a(true);
                    }
                } else {
                    this.a.closeActivity();
                }
            } else {
                this.a.J();
                TiebaStatic.eventStat(this.a, "frs_forum_name", "frsclick", 1, new Object[0]);
            }
        } else {
            TiebaStatic.eventStat(this.a, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.a.b(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.v.frs_bt_create) {
            this.a.D();
        } else if (id == com.baidu.tieba.v.btn_love) {
            ctVar32 = this.a.v;
            if (!ctVar32.t() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.j();
            }
        } else if (id == com.baidu.tieba.v.btn_sign) {
            ctVar30 = this.a.v;
            if (!ctVar30.t() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                ctVar31 = this.a.v;
                if (!ctVar31.G()) {
                    this.a.l();
                }
            }
        } else if (id == com.baidu.tieba.v.add_fan) {
            ctVar29 = this.a.v;
            if (!ctVar29.t() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                f a = f.a();
                str7 = this.a.m;
                a.b(str7);
                this.a.i();
            }
        } else if (id == com.baidu.tieba.v.refresh_layout) {
            TiebaStatic.eventStat(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            ctVar28 = this.a.v;
            ctVar28.R();
        } else if (id == com.baidu.tieba.v.message_layout) {
            FrsActivity.c = false;
            FrsActivity.b = false;
            this.a.g();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                context = this.a.ad;
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bn(context, true)));
            }
        } else if (id == com.baidu.tieba.v.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ax(this.a)));
        } else if (id == com.baidu.tieba.v.forum_manager_center) {
            String str8 = "";
            gVar15 = this.a.H;
            if (gVar15 != null) {
                gVar16 = this.a.H;
                if (gVar16.g() != null) {
                    gVar17 = this.a.H;
                    str8 = gVar17.g().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str6 = this.a.m;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str6).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.v.recommend_forum_item_layout) {
            dt dtVar = (dt) view.getTag();
            if (dtVar != null) {
                String str9 = dtVar.a;
                str5 = this.a.m;
                if (str9.equals(str5)) {
                    ctVar26 = this.a.v;
                    if (ctVar26.n().isMenuShowing()) {
                        ctVar27 = this.a.v;
                        ctVar27.n().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.w = "sidebar";
                this.a.x = dtVar.b;
                this.a.c(str9);
            }
        } else if (id == com.baidu.tieba.v.frs_header_groups) {
            gVar9 = this.a.H;
            if (gVar9 != null) {
                gVar10 = this.a.H;
                if (gVar10.g() != null) {
                    gVar11 = this.a.H;
                    if (!com.baidu.adp.lib.util.i.b(gVar11.g().getId())) {
                        gVar12 = this.a.H;
                        if (gVar12.p() != null) {
                            TiebaStatic.eventStat(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity4 = this.a;
                            gVar13 = this.a.H;
                            String id2 = gVar13.g().getId();
                            gVar14 = this.a.H;
                            this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.s(frsActivity4, id2, gVar14.p().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.btn_love_content) {
            ctVar22 = this.a.v;
            if (!ctVar22.t()) {
                z3 = this.a.S;
                if (!z3) {
                    ctVar23 = this.a.v;
                    if (ctVar23 != null) {
                        str3 = this.a.N;
                        if (str3.equals("normal_page")) {
                            ctVar25 = this.a.v;
                            ctVar25.a(view);
                            return;
                        }
                        str4 = this.a.N;
                        if (str4.equals("frs_page")) {
                            ctVar24 = this.a.v;
                            ctVar24.b(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            ctVar21 = this.a.v;
            ctVar21.Q();
        } else if (id == com.baidu.tieba.v.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                gVar2 = this.a.H;
                if (gVar2 != null) {
                    gVar3 = this.a.H;
                    if (gVar3.g() != null) {
                        gVar4 = this.a.H;
                        if (gVar4.g().getAnchorPower() != null) {
                            gVar5 = this.a.H;
                            if (gVar5.g().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.f.a(this.a.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.a;
                                gVar7 = this.a.H;
                                int a2 = com.baidu.adp.lib.f.b.a(gVar7.g().getId(), 0);
                                gVar8 = this.a.H;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.aj(frsActivity5, a2, gVar8.g().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.a;
                            gVar6 = this.a.H;
                            frsActivity6.showToast(gVar6.g().getAnchorPower().anchor_message);
                            return;
                        }
                        this.a.showToast(com.baidu.tieba.y.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.y.live_error_system_not_support);
        }
    }
}
