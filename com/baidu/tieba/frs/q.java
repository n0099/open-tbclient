package com.baidu.tieba.frs;

import android.app.Activity;
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
        ct ctVar12;
        String str;
        ay ayVar;
        ay ayVar2;
        ct ctVar13;
        g gVar;
        String str2;
        ct ctVar14;
        ct ctVar15;
        boolean z;
        ct ctVar16;
        ct ctVar17;
        ct ctVar18;
        boolean z2;
        ct ctVar19;
        ct ctVar20;
        ct ctVar21;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        g gVar8;
        ct ctVar22;
        ct ctVar23;
        boolean z3;
        ct ctVar24;
        String str3;
        String str4;
        ct ctVar25;
        ct ctVar26;
        g gVar9;
        g gVar10;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        String str5;
        ct ctVar27;
        ct ctVar28;
        g gVar15;
        String str6;
        g gVar16;
        g gVar17;
        ct ctVar29;
        ct ctVar30;
        String str7;
        ct ctVar31;
        ct ctVar32;
        ct ctVar33;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
        ctVar = this.a.w;
        if (view != ctVar.j()) {
            ctVar2 = this.a.w;
            if (view != ctVar2.d()) {
                ctVar3 = this.a.w;
                if (view != ctVar3.i()) {
                    ctVar4 = this.a.w;
                    if (view != ctVar4.l()) {
                        ctVar5 = this.a.w;
                        if (view != ctVar5.k()) {
                            ctVar6 = this.a.w;
                            if (view == ctVar6.e()) {
                                ctVar17 = this.a.w;
                                ctVar17.b();
                                ctVar18 = this.a.w;
                                if (ctVar18.o().isMenuShowing()) {
                                    ctVar19 = this.a.w;
                                    ctVar19.o().toggle(true);
                                }
                                z2 = this.a.E;
                                if (z2) {
                                    this.a.E = false;
                                    this.a.E();
                                }
                            } else {
                                ctVar7 = this.a.w;
                                if (view != ctVar7.f()) {
                                    ctVar8 = this.a.w;
                                    if (view != ctVar8.g()) {
                                        ctVar9 = this.a.w;
                                        if (view != ctVar9.h()) {
                                            ctVar10 = this.a.w;
                                            FrsHeaderView w = ctVar10.w();
                                            ctVar11 = this.a.w;
                                            com.baidu.tieba.frs.view.j x = ctVar11.x();
                                            if ((w != null && w.b(view)) || (x != null && x.b(view))) {
                                                com.baidu.tbadk.core.f.a(this.a.getParent(), "forum_fortune_click");
                                                if (!TbadkApplication.isLogin()) {
                                                    LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                                                } else {
                                                    this.a.K();
                                                }
                                            }
                                        } else {
                                            TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                            ctVar12 = this.a.w;
                                            ctVar12.b();
                                            FrsActivity frsActivity = this.a;
                                            FrsActivity frsActivity2 = this.a;
                                            str = this.a.n;
                                            frsActivity.X = new ay(frsActivity2, str);
                                            ayVar = this.a.X;
                                            ayVar.setSelfExecute(true);
                                            ayVar2 = this.a.X;
                                            ayVar2.execute(new String[0]);
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a, "frs_image_threads", "frsclick", 1, new Object[0]);
                                        ctVar13 = this.a.w;
                                        ctVar13.b();
                                        TbadkApplication m252getInst = TbadkApplication.m252getInst();
                                        gVar = this.a.I;
                                        m252getInst.addFrsImageForum(gVar.g().getName());
                                        FrsActivity frsActivity3 = this.a;
                                        com.baidu.tbadk.core.atomData.m mVar = new com.baidu.tbadk.core.atomData.m(this.a);
                                        str2 = this.a.n;
                                        frsActivity3.sendMessage(new CustomMessage(2005002, mVar.b(str2, null, 0)));
                                        this.a.g();
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.a, "frs_good_threads", "frsclick", 1, new Object[0]);
                                    ctVar14 = this.a.w;
                                    ctVar14.b();
                                    ctVar15 = this.a.w;
                                    if (ctVar15.o().isMenuShowing()) {
                                        ctVar16 = this.a.w;
                                        ctVar16.o().toggle(true);
                                    }
                                    z = this.a.E;
                                    if (!z) {
                                        this.a.E = true;
                                        this.a.E();
                                    }
                                }
                            }
                        } else {
                            TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                            ctVar20 = this.a.w;
                            ctVar20.Q();
                            FrsActivity.b = false;
                            ctVar21 = this.a.w;
                            ctVar21.a(true);
                        }
                    } else {
                        this.a.closeActivity();
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
            ctVar33 = this.a.w;
            if (!ctVar33.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.j();
            }
        } else if (id == com.baidu.tieba.v.btn_sign) {
            ctVar31 = this.a.w;
            if (!ctVar31.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                ctVar32 = this.a.w;
                if (!ctVar32.H()) {
                    this.a.l();
                }
            }
        } else if (id == com.baidu.tieba.v.add_fan) {
            ctVar30 = this.a.w;
            if (!ctVar30.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                f a = f.a();
                str7 = this.a.n;
                a.b(str7);
                this.a.i();
            }
        } else if (id == com.baidu.tieba.v.refresh_layout) {
            TiebaStatic.eventStat(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            ctVar29 = this.a.w;
            ctVar29.S();
        } else if (id == com.baidu.tieba.v.message_layout) {
            FrsActivity.c = false;
            FrsActivity.b = false;
            this.a.f();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2017003, new com.baidu.tbadk.core.frameworkData.a(this.a)));
            }
        } else if (id == com.baidu.tieba.v.forum_manager_center) {
            String str8 = "";
            gVar15 = this.a.I;
            if (gVar15 != null) {
                gVar16 = this.a.I;
                if (gVar16.g() != null) {
                    gVar17 = this.a.I;
                    str8 = gVar17.g().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str6 = this.a.n;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str6).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.v.recommend_forum_item_layout) {
            dt dtVar = (dt) view.getTag();
            if (dtVar != null) {
                String str9 = dtVar.a;
                str5 = this.a.n;
                if (str9.equals(str5)) {
                    ctVar27 = this.a.w;
                    if (ctVar27.o().isMenuShowing()) {
                        ctVar28 = this.a.w;
                        ctVar28.o().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.x = "sidebar";
                this.a.y = dtVar.b;
                this.a.c(str9);
            }
        } else if (id == com.baidu.tieba.v.frs_header_groups) {
            gVar9 = this.a.I;
            if (gVar9 != null) {
                gVar10 = this.a.I;
                if (gVar10.g() != null) {
                    gVar11 = this.a.I;
                    if (!com.baidu.adp.lib.util.j.b(gVar11.g().getId())) {
                        gVar12 = this.a.I;
                        if (gVar12.p() != null) {
                            TiebaStatic.eventStat(this.a, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity4 = this.a;
                            gVar13 = this.a.I;
                            String id2 = gVar13.g().getId();
                            gVar14 = this.a.I;
                            this.a.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.n(frsActivity4, id2, gVar14.p().b() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.btn_love_content) {
            ctVar23 = this.a.w;
            if (!ctVar23.u()) {
                z3 = this.a.T;
                if (!z3) {
                    ctVar24 = this.a.w;
                    if (ctVar24 != null) {
                        str3 = this.a.O;
                        if (str3.equals("normal_page")) {
                            ctVar26 = this.a.w;
                            ctVar26.a(view);
                            return;
                        }
                        str4 = this.a.O;
                        if (str4.equals("frs_page")) {
                            ctVar25 = this.a.w;
                            ctVar25.b(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            ctVar22 = this.a.w;
            ctVar22.R();
        } else if (id == com.baidu.tieba.v.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                gVar2 = this.a.I;
                if (gVar2 != null) {
                    gVar3 = this.a.I;
                    if (gVar3.g() != null) {
                        gVar4 = this.a.I;
                        if (gVar4.g().getAnchorPower() != null) {
                            gVar5 = this.a.I;
                            if (gVar5.g().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.f.a(this.a.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.a;
                                gVar7 = this.a.I;
                                int a2 = com.baidu.adp.lib.f.b.a(gVar7.g().getId(), 0);
                                gVar8 = this.a.I;
                                messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ae(frsActivity5, a2, gVar8.g().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.a;
                            gVar6 = this.a.I;
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
