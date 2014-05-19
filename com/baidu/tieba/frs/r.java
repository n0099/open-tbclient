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
class r implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        cs csVar4;
        cs csVar5;
        cs csVar6;
        cs csVar7;
        cs csVar8;
        cs csVar9;
        cs csVar10;
        cs csVar11;
        cs csVar12;
        String str;
        az azVar;
        az azVar2;
        cs csVar13;
        g gVar;
        String str2;
        cs csVar14;
        cs csVar15;
        boolean z;
        cs csVar16;
        cs csVar17;
        cs csVar18;
        boolean z2;
        cs csVar19;
        cs csVar20;
        cs csVar21;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        g gVar8;
        cs csVar22;
        cs csVar23;
        boolean z3;
        cs csVar24;
        String str3;
        String str4;
        cs csVar25;
        cs csVar26;
        g gVar9;
        g gVar10;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        String str5;
        cs csVar27;
        cs csVar28;
        g gVar15;
        String str6;
        g gVar16;
        g gVar17;
        cs csVar29;
        cs csVar30;
        String str7;
        cs csVar31;
        cs csVar32;
        cs csVar33;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
        csVar = this.a.w;
        if (view != csVar.j()) {
            csVar2 = this.a.w;
            if (view != csVar2.d()) {
                csVar3 = this.a.w;
                if (view != csVar3.i()) {
                    csVar4 = this.a.w;
                    if (view != csVar4.l()) {
                        csVar5 = this.a.w;
                        if (view != csVar5.k()) {
                            csVar6 = this.a.w;
                            if (view == csVar6.e()) {
                                csVar17 = this.a.w;
                                csVar17.b();
                                csVar18 = this.a.w;
                                if (csVar18.o().isMenuShowing()) {
                                    csVar19 = this.a.w;
                                    csVar19.o().toggle(true);
                                }
                                z2 = this.a.E;
                                if (z2) {
                                    this.a.E = false;
                                    this.a.D();
                                }
                            } else {
                                csVar7 = this.a.w;
                                if (view != csVar7.f()) {
                                    csVar8 = this.a.w;
                                    if (view != csVar8.g()) {
                                        csVar9 = this.a.w;
                                        if (view != csVar9.h()) {
                                            csVar10 = this.a.w;
                                            FrsHeaderView w = csVar10.w();
                                            csVar11 = this.a.w;
                                            com.baidu.tieba.frs.view.j x = csVar11.x();
                                            if ((w != null && w.b(view)) || (x != null && x.b(view))) {
                                                com.baidu.tbadk.core.g.a(this.a.getParent(), "forum_fortune_click");
                                                if (!TbadkApplication.isLogin()) {
                                                    LoginActivity.a((Activity) this.a, (String) null, true, 18004);
                                                } else {
                                                    this.a.J();
                                                }
                                            }
                                        } else {
                                            TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                            csVar12 = this.a.w;
                                            csVar12.b();
                                            FrsActivity frsActivity = this.a;
                                            FrsActivity frsActivity2 = this.a;
                                            str = this.a.n;
                                            frsActivity.Y = new az(frsActivity2, str);
                                            azVar = this.a.Y;
                                            azVar.setSelfExecute(true);
                                            azVar2 = this.a.Y;
                                            azVar2.execute(new String[0]);
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a, "frs_image_threads", "frsclick", 1, new Object[0]);
                                        csVar13 = this.a.w;
                                        csVar13.b();
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
                                    csVar14 = this.a.w;
                                    csVar14.b();
                                    csVar15 = this.a.w;
                                    if (csVar15.o().isMenuShowing()) {
                                        csVar16 = this.a.w;
                                        csVar16.o().toggle(true);
                                    }
                                    z = this.a.E;
                                    if (!z) {
                                        this.a.E = true;
                                        this.a.D();
                                    }
                                }
                            }
                        } else {
                            TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                            csVar20 = this.a.w;
                            csVar20.Q();
                            FrsActivity.b = false;
                            csVar21 = this.a.w;
                            csVar21.a(true);
                        }
                    } else {
                        this.a.closeActivity();
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
        if (id == com.baidu.tieba.r.frs_bt_create) {
            this.a.C();
        } else if (id == com.baidu.tieba.r.btn_love) {
            csVar33 = this.a.w;
            if (!csVar33.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.a.j();
            }
        } else if (id == com.baidu.tieba.r.btn_sign) {
            csVar31 = this.a.w;
            if (!csVar31.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                csVar32 = this.a.w;
                if (!csVar32.H()) {
                    this.a.l();
                }
            }
        } else if (id == com.baidu.tieba.r.add_fan) {
            csVar30 = this.a.w;
            if (!csVar30.u() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                f a = f.a();
                str7 = this.a.n;
                a.b(str7);
                this.a.i();
            }
        } else if (id == com.baidu.tieba.r.refresh_layout) {
            TiebaStatic.eventStat(this.a, "frs_refresh", "frsclick", 1, new Object[0]);
            csVar29 = this.a.w;
            csVar29.S();
        } else if (id == com.baidu.tieba.r.message_layout) {
            FrsActivity.c = false;
            FrsActivity.b = false;
            this.a.f();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2017003, new com.baidu.tbadk.core.frameworkData.a(this.a)));
            }
        } else if (id == com.baidu.tieba.r.forum_manager_center) {
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
        } else if (id == com.baidu.tieba.r.recommend_forum_item_layout) {
            ds dsVar = (ds) view.getTag();
            if (dsVar != null) {
                String str9 = dsVar.a;
                TiebaStatic.eventStat(this.a, "sidebar_show", "sidebar_click", 1, "st_param", dsVar.b);
                str5 = this.a.n;
                if (str9.equals(str5)) {
                    csVar27 = this.a.w;
                    if (csVar27.o().isMenuShowing()) {
                        csVar28 = this.a.w;
                        csVar28.o().toggle(true);
                        return;
                    }
                    return;
                }
                this.a.x = "sidebar";
                this.a.y = dsVar.b;
                this.a.c(str9);
            }
        } else if (id == com.baidu.tieba.r.frs_header_groups) {
            gVar9 = this.a.I;
            if (gVar9 != null) {
                gVar10 = this.a.I;
                if (gVar10.g() != null) {
                    gVar11 = this.a.I;
                    if (!com.baidu.adp.lib.util.g.b(gVar11.g().getId())) {
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
        } else if (id == com.baidu.tieba.r.btn_love_content) {
            csVar23 = this.a.w;
            if (!csVar23.u()) {
                z3 = this.a.U;
                if (!z3) {
                    csVar24 = this.a.w;
                    if (csVar24 != null) {
                        str3 = this.a.O;
                        if (str3.equals("normal_page")) {
                            csVar26 = this.a.w;
                            csVar26.a(view);
                            return;
                        }
                        str4 = this.a.O;
                        if (str4.equals("frs_page")) {
                            csVar25 = this.a.w;
                            csVar25.b(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.r.frs_new_guide) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean(FrsActivity.a, true);
            edit.commit();
            csVar22 = this.a.w;
            csVar22.R();
        } else if (id == com.baidu.tieba.r.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                gVar2 = this.a.I;
                if (gVar2 != null) {
                    gVar3 = this.a.I;
                    if (gVar3.g() != null) {
                        gVar4 = this.a.I;
                        if (gVar4.g().getAnchorPower() != null) {
                            gVar5 = this.a.I;
                            if (gVar5.g().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.g.a(this.a.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.a;
                                gVar7 = this.a.I;
                                int a2 = com.baidu.adp.lib.f.b.a(gVar7.g().getId(), 0);
                                gVar8 = this.a.I;
                                messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.af(frsActivity5, a2, gVar8.g().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.a;
                            gVar6 = this.a.I;
                            frsActivity6.showToast(gVar6.g().getAnchorPower().anchor_message);
                            return;
                        }
                        this.a.showToast(com.baidu.tieba.u.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.u.live_error_system_not_support);
        }
    }
}
