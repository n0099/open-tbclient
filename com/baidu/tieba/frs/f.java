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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
        if (r12 == r3.Gu().Hf()) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (r12 == r3.Gt().Hf()) goto L7;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        bq bqVar7;
        bq bqVar8;
        bq bqVar9;
        bq bqVar10;
        bq bqVar11;
        bq bqVar12;
        String str;
        ay ayVar;
        ay ayVar2;
        bq bqVar13;
        bq bqVar14;
        boolean z;
        bq bqVar15;
        bq bqVar16;
        bq bqVar17;
        boolean z2;
        bq bqVar18;
        bq bqVar19;
        cx cxVar;
        boolean z3;
        boolean z4;
        boolean z5;
        bq bqVar20;
        bq bqVar21;
        bq bqVar22;
        bq bqVar23;
        boolean z6;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        com.baidu.tieba.tbadkCore.e eVar6;
        com.baidu.tieba.tbadkCore.e eVar7;
        bq bqVar24;
        bq bqVar25;
        boolean z7;
        bq bqVar26;
        String str2;
        String str3;
        bq bqVar27;
        bq bqVar28;
        com.baidu.tieba.tbadkCore.e eVar8;
        com.baidu.tieba.tbadkCore.e eVar9;
        com.baidu.tieba.tbadkCore.e eVar10;
        com.baidu.tieba.tbadkCore.e eVar11;
        com.baidu.tieba.tbadkCore.e eVar12;
        com.baidu.tieba.tbadkCore.e eVar13;
        com.baidu.tieba.tbadkCore.e eVar14;
        com.baidu.tieba.tbadkCore.e eVar15;
        com.baidu.tieba.tbadkCore.e eVar16;
        String str4;
        bq bqVar29;
        bq bqVar30;
        com.baidu.tieba.tbadkCore.e eVar17;
        String str5;
        com.baidu.tieba.tbadkCore.e eVar18;
        com.baidu.tieba.tbadkCore.e eVar19;
        com.baidu.tieba.tbadkCore.e eVar20;
        bq bqVar31;
        bq bqVar32;
        bq bqVar33;
        bq bqVar34;
        bq bqVar35;
        bq bqVar36;
        com.baidu.tieba.tbadkCore.e eVar21;
        bq bqVar37;
        bq bqVar38;
        com.baidu.tieba.tbadkCore.e eVar22;
        bq bqVar39;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aCV.getPageContext().getPageActivity());
        bqVar = this.aCV.aBX;
        if (bqVar.Gt() != null) {
            bqVar38 = this.aCV.aBX;
            if (view != bqVar38.Gt().He()) {
                bqVar39 = this.aCV.aBX;
            }
            MessageManager messageManager = MessageManager.getInstance();
            Activity pageActivity = this.aCV.getPageContext().getPageActivity();
            eVar22 = this.aCV.aCh;
            messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, eVar22.aej().getId(), ForumDetailActivityConfig.FromType.FRS)));
            return;
        }
        bqVar2 = this.aCV.aBX;
        if (bqVar2.Gu() != null) {
            bqVar36 = this.aCV.aBX;
            if (view != bqVar36.Gu().He()) {
                bqVar37 = this.aCV.aBX;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            Activity pageActivity2 = this.aCV.getPageContext().getPageActivity();
            eVar21 = this.aCV.aCh;
            messageManager2.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity2, eVar21.aej().getId(), ForumDetailActivityConfig.FromType.FRS)));
            return;
        }
        bqVar3 = this.aCV.aBX;
        if (view != bqVar3.Gl()) {
            bqVar4 = this.aCV.aBX;
            if (view == bqVar4.Gh()) {
                bqVar23 = this.aCV.aBX;
                z6 = this.aCV.aCf;
                bqVar23.bL(z6);
                TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bqVar5 = this.aCV.aBX;
                if (view != bqVar5.Gm()) {
                    bqVar6 = this.aCV.aBX;
                    if (view == bqVar6.getMoreButton()) {
                        bqVar19 = this.aCV.aBX;
                        cxVar = this.aCV.aCk;
                        z3 = FrsActivity.aBM;
                        z4 = FrsActivity.aBN;
                        z5 = FrsActivity.aBO;
                        bqVar19.a(cxVar, z3, z4, z5);
                        TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bqVar20 = this.aCV.aBX;
                        bqVar20.GM();
                        bqVar21 = this.aCV.aBX;
                        bqVar21.Fj();
                        FrsActivity.aBM = false;
                        bqVar22 = this.aCV.aBX;
                        bqVar22.showMenu(true);
                    } else {
                        bqVar7 = this.aCV.aBX;
                        if (view == bqVar7.Gi()) {
                            bqVar16 = this.aCV.aBX;
                            bqVar16.Ge();
                            bqVar17 = this.aCV.aBX;
                            if (bqVar17.Gp().isMenuShowing()) {
                                bqVar18 = this.aCV.aBX;
                                bqVar18.Gp().toggle(true);
                            }
                            z2 = this.aCV.aCf;
                            if (z2) {
                                this.aCV.aCf = false;
                                this.aCV.refresh();
                            }
                        } else {
                            bqVar8 = this.aCV.aBX;
                            if (view != bqVar8.Gj()) {
                                bqVar9 = this.aCV.aBX;
                                if (view != bqVar9.Gk()) {
                                    bqVar10 = this.aCV.aBX;
                                    FrsHeaderView Gt = bqVar10.Gt();
                                    bqVar11 = this.aCV.aBX;
                                    com.baidu.tieba.frs.view.o Gu = bqVar11.Gu();
                                    if ((Gt != null && Gt.z(view)) || (Gu != null && Gu.z(view))) {
                                        com.baidu.tbadk.core.i.B(this.aCV.getParent(), "forum_fortune_click");
                                        if (!TbadkCoreApplication.isLogin()) {
                                            this.aCV.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aCV.getPageContext().getPageActivity(), (String) null, true, 18004)));
                                        } else {
                                            this.aCV.FF();
                                        }
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bqVar12 = this.aCV.aBX;
                                    bqVar12.Ge();
                                    FrsActivity frsActivity = this.aCV;
                                    FrsActivity frsActivity2 = this.aCV;
                                    str = this.aCV.aBP;
                                    frsActivity.aCq = new ay(frsActivity2, str);
                                    ayVar = this.aCV.aCq;
                                    ayVar.setSelfExecute(true);
                                    ayVar2 = this.aCV.aCq;
                                    ayVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bqVar13 = this.aCV.aBX;
                                bqVar13.Ge();
                                bqVar14 = this.aCV.aBX;
                                if (bqVar14.Gp().isMenuShowing()) {
                                    bqVar15 = this.aCV.aBX;
                                    bqVar15.Gp().toggle(true);
                                }
                                z = this.aCV.aCf;
                                if (!z) {
                                    this.aCV.aCf = true;
                                    this.aCV.refresh();
                                }
                            }
                        }
                    }
                } else {
                    this.aCV.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aCV.eC(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.w.btn_love) {
            bqVar35 = this.aCV.aBX;
            if (!bqVar35.Gs() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aCV.kD();
            }
        } else if (id == com.baidu.tieba.w.btn_sign) {
            bqVar33 = this.aCV.aBX;
            if (!bqVar33.Gs() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                bqVar34 = this.aCV.aBX;
                if (!bqVar34.GE()) {
                    this.aCV.FH();
                }
            }
        } else if (id == com.baidu.tieba.w.refresh_layout) {
            TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bqVar31 = this.aCV.aBX;
            bqVar31.Fj();
            bqVar32 = this.aCV.aBX;
            bqVar32.jK();
        } else if (id == com.baidu.tieba.w.message_layout) {
            FrsActivity.aBM = false;
            FrsActivity.aBN = false;
            this.aCV.Fx();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.aCV.sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(this.aCV.getPageContext().getPageActivity())));
            }
        } else if (id == com.baidu.tieba.w.mention_layout) {
            FrsActivity.aBM = false;
            FrsActivity.aBO = false;
            this.aCV.Fx();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                this.aCV.sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(this.aCV.getPageContext().getPageActivity())));
            }
        } else if (id == com.baidu.tieba.w.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aCV.getPageContext().getPageActivity())));
        } else if (id == com.baidu.tieba.w.bar_info_layout) {
            MessageManager messageManager3 = MessageManager.getInstance();
            Activity pageActivity3 = this.aCV.getPageContext().getPageActivity();
            eVar20 = this.aCV.aCh;
            messageManager3.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity3, eVar20.aej().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
        } else if (id == com.baidu.tieba.w.forum_manager_center) {
            String str6 = "";
            eVar17 = this.aCV.aCh;
            if (eVar17 != null) {
                eVar18 = this.aCV.aCh;
                if (eVar18.aej() != null) {
                    eVar19 = this.aCV.aCh;
                    str6 = eVar19.aej().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str5 = this.aCV.aBP;
            com.baidu.tbadk.browser.a.y(this.aCV.getPageContext().getPageActivity(), sb.append(str5).append("&fid=").append(str6).toString());
        } else if (id == com.baidu.tieba.w.recommend_forum_item_layout) {
            dd ddVar = (dd) view.getTag();
            if (ddVar != null) {
                String str7 = ddVar.name;
                str4 = this.aCV.aBP;
                if (str7.equals(str4)) {
                    bqVar29 = this.aCV.aBX;
                    if (bqVar29.Gp().isMenuShowing()) {
                        bqVar30 = this.aCV.aBX;
                        bqVar30.Gp().toggle(true);
                        return;
                    }
                    return;
                }
                this.aCV.aBY = "sidebar";
                this.aCV.aBZ = ddVar.aGw;
                this.aCV.fz(str7);
            }
        } else if (id == com.baidu.tieba.w.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.fg()) {
                this.aCV.FG();
            } else {
                this.aCV.showToast(com.baidu.tieba.z.neterror);
            }
        } else if (id == com.baidu.tieba.w.frs_header_groups) {
            eVar11 = this.aCV.aCh;
            if (eVar11 != null) {
                eVar12 = this.aCV.aCh;
                if (eVar12.aej() != null) {
                    eVar13 = this.aCV.aCh;
                    if (!com.baidu.adp.lib.util.k.isEmpty(eVar13.aej().getId())) {
                        eVar14 = this.aCV.aCh;
                        if (eVar14.aem() != null) {
                            TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                            Activity pageActivity4 = this.aCV.getPageContext().getPageActivity();
                            eVar15 = this.aCV.aCh;
                            String id2 = eVar15.aej().getId();
                            eVar16 = this.aCV.aCh;
                            this.aCV.sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(pageActivity4, id2, eVar16.aem().aec() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.frs_header_games) {
            eVar8 = this.aCV.aCh;
            if (eVar8 != null) {
                eVar9 = this.aCV.aCh;
                if (eVar9.aeg() != null) {
                    eVar10 = this.aCV.aCh;
                    String aeg = eVar10.aeg();
                    int cv = com.baidu.tbadk.core.util.u.cv(aeg);
                    if (cv == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aCV.getPageContext().getPageActivity(), null, aeg, true)));
                    } else if (cv == 1) {
                        String in = com.baidu.tieba.tbadkCore.util.k.in(aeg);
                        if (!TextUtils.isEmpty(in)) {
                            TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", in, "ref_id", "1000601");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aCV.getPageContext().getPageActivity(), in, "1000601")));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.btn_love_content) {
            bqVar25 = this.aCV.aBX;
            if (!bqVar25.Gs()) {
                z7 = this.aCV.aCn;
                if (!z7) {
                    bqVar26 = this.aCV.aBX;
                    if (bqVar26 != null) {
                        str2 = this.aCV.mPageType;
                        if (str2.equals("normal_page")) {
                            bqVar28 = this.aCV.aBX;
                            bqVar28.w(view);
                            return;
                        }
                        str3 = this.aCV.mPageType;
                        if (str3.equals("frs_page")) {
                            bqVar27 = this.aCV.aBX;
                            bqVar27.x(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.frs_new_guide) {
            SharedPreferences.Editor edit = this.aCV.getPageContext().getPageActivity().getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean("has_shown_frs_guide", true);
            edit.commit();
            bqVar24 = this.aCV.aBX;
            bqVar24.GN();
        } else if (id == com.baidu.tieba.w.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                eVar = this.aCV.aCh;
                if (eVar != null) {
                    eVar2 = this.aCV.aCh;
                    if (eVar2.aej() != null) {
                        eVar3 = this.aCV.aCh;
                        if (eVar3.aej().getAnchorPower() != null) {
                            eVar4 = this.aCV.aCh;
                            if (eVar4.aej().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.i.B(this.aCV.getBaseContext(), "start_live_bt");
                                MessageManager messageManager4 = MessageManager.getInstance();
                                Activity pageActivity5 = this.aCV.getPageContext().getPageActivity();
                                eVar6 = this.aCV.aCh;
                                int i = com.baidu.adp.lib.g.c.toInt(eVar6.aej().getId(), 0);
                                eVar7 = this.aCV.aCh;
                                messageManager4.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity5, i, eVar7.aej().getName())));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aCV;
                            eVar5 = this.aCV.aCh;
                            frsActivity3.showToast(eVar5.aej().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aCV.showToast(com.baidu.tieba.z.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aCV.showToast(com.baidu.tieba.z.live_error_system_not_support);
        }
    }
}
