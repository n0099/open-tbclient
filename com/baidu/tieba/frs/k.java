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
import com.baidu.tbadk.core.atomData.BackupLiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        bu buVar5;
        bu buVar6;
        bu buVar7;
        bu buVar8;
        bu buVar9;
        bu buVar10;
        String str;
        bc bcVar;
        bc bcVar2;
        bu buVar11;
        bu buVar12;
        boolean z;
        bu buVar13;
        bu buVar14;
        bu buVar15;
        boolean z2;
        bu buVar16;
        bu buVar17;
        cz czVar;
        boolean z3;
        boolean z4;
        boolean z5;
        bu buVar18;
        bu buVar19;
        bu buVar20;
        bu buVar21;
        boolean z6;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        b bVar9;
        bu buVar22;
        bu buVar23;
        boolean z7;
        bu buVar24;
        String str2;
        String str3;
        bu buVar25;
        bu buVar26;
        b bVar10;
        b bVar11;
        b bVar12;
        b bVar13;
        b bVar14;
        b bVar15;
        b bVar16;
        b bVar17;
        b bVar18;
        String str4;
        bu buVar27;
        bu buVar28;
        b bVar19;
        String str5;
        b bVar20;
        b bVar21;
        bu buVar29;
        bu buVar30;
        bu buVar31;
        bu buVar32;
        bu buVar33;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aBu);
        buVar = this.aBu.aAF;
        if (view != buVar.Gg()) {
            buVar2 = this.aBu.aAF;
            if (view == buVar2.Gc()) {
                buVar21 = this.aBu.aAF;
                z6 = this.aBu.aAN;
                buVar21.ca(z6);
                TiebaStatic.eventStat(this.aBu, "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                buVar3 = this.aBu.aAF;
                if (view != buVar3.Gi()) {
                    buVar4 = this.aBu.aAF;
                    if (view == buVar4.Gh()) {
                        buVar17 = this.aBu.aAF;
                        czVar = this.aBu.aAR;
                        z3 = FrsActivity.aAu;
                        z4 = FrsActivity.aAv;
                        z5 = FrsActivity.aAw;
                        buVar17.a(czVar, z3, z4, z5);
                        TiebaStatic.eventStat(this.aBu, "frs_more", "frsclick", 1, new Object[0]);
                        buVar18 = this.aBu.aAF;
                        buVar18.GH();
                        buVar19 = this.aBu.aAF;
                        buVar19.ER();
                        FrsActivity.aAu = false;
                        buVar20 = this.aBu.aAF;
                        buVar20.showMenu(true);
                    } else {
                        buVar5 = this.aBu.aAF;
                        if (view == buVar5.Gd()) {
                            buVar14 = this.aBu.aAF;
                            buVar14.FZ();
                            buVar15 = this.aBu.aAF;
                            if (buVar15.getSlidingMenu().isMenuShowing()) {
                                buVar16 = this.aBu.aAF;
                                buVar16.getSlidingMenu().toggle(true);
                            }
                            z2 = this.aBu.aAN;
                            if (z2) {
                                this.aBu.aAN = false;
                                this.aBu.refresh();
                            }
                        } else {
                            buVar6 = this.aBu.aAF;
                            if (view != buVar6.Ge()) {
                                buVar7 = this.aBu.aAF;
                                if (view != buVar7.Gf()) {
                                    buVar8 = this.aBu.aAF;
                                    FrsHeaderView Go = buVar8.Go();
                                    buVar9 = this.aBu.aAF;
                                    com.baidu.tieba.frs.view.r Gp = buVar9.Gp();
                                    if ((Go != null && Go.E(view)) || (Gp != null && Gp.E(view))) {
                                        com.baidu.tbadk.core.j.l(this.aBu.getParent(), "forum_fortune_click");
                                        if (!TbadkApplication.isLogin()) {
                                            LoginActivity.a((Activity) this.aBu, (String) null, true, 18004);
                                        } else {
                                            this.aBu.FA();
                                        }
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.aBu, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    buVar10 = this.aBu.aAF;
                                    buVar10.FZ();
                                    FrsActivity frsActivity = this.aBu;
                                    FrsActivity frsActivity2 = this.aBu;
                                    str = this.aBu.aAx;
                                    frsActivity.aAV = new bc(frsActivity2, str);
                                    bcVar = this.aBu.aAV;
                                    bcVar.setSelfExecute(true);
                                    bcVar2 = this.aBu.aAV;
                                    bcVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aBu, "frs_good_threads", "frsclick", 1, new Object[0]);
                                buVar11 = this.aBu.aAF;
                                buVar11.FZ();
                                buVar12 = this.aBu.aAF;
                                if (buVar12.getSlidingMenu().isMenuShowing()) {
                                    buVar13 = this.aBu.aAF;
                                    buVar13.getSlidingMenu().toggle(true);
                                }
                                z = this.aBu.aAN;
                                if (!z) {
                                    this.aBu.aAN = true;
                                    this.aBu.refresh();
                                }
                            }
                        }
                    }
                } else {
                    this.aBu.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aBu, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aBu.eE(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.v.btn_love) {
            buVar33 = this.aBu.aAF;
            if (!buVar33.Gn() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aBu.FB();
            }
        } else if (id == com.baidu.tieba.v.btn_sign) {
            buVar31 = this.aBu.aAF;
            if (!buVar31.Gn() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                buVar32 = this.aBu.aAF;
                if (!buVar32.Gz()) {
                    this.aBu.FD();
                }
            }
        } else if (id == com.baidu.tieba.v.refresh_layout) {
            TiebaStatic.eventStat(this.aBu, "frs_refresh", "frsclick", 1, new Object[0]);
            buVar29 = this.aBu.aAF;
            buVar29.ER();
            buVar30 = this.aBu.aAF;
            buVar30.hO();
        } else if (id == com.baidu.tieba.v.message_layout) {
            FrsActivity.aAu = false;
            FrsActivity.aAv = false;
            this.aBu.Fs();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.aBu.sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(this.aBu)));
            }
        } else if (id == com.baidu.tieba.v.mention_layout) {
            FrsActivity.aAu = false;
            FrsActivity.aAw = false;
            this.aBu.Fs();
            String currentAccount2 = TbadkApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aBu, "frs_message", "frsclick", 1, new Object[0]);
                this.aBu.sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig((Context) this.aBu, false)));
            }
        } else if (id == com.baidu.tieba.v.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aBu)));
        } else if (id == com.baidu.tieba.v.forum_manager_center) {
            String str6 = "";
            bVar19 = this.aBu.azN;
            if (bVar19 != null) {
                bVar20 = this.aBu.azN;
                if (bVar20.zL() != null) {
                    bVar21 = this.aBu.azN;
                    str6 = bVar21.zL().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str5 = this.aBu.aAx;
            com.baidu.tbadk.browser.a.i(this.aBu, sb.append(str5).append("&fid=").append(str6).toString());
        } else if (id == com.baidu.tieba.v.recommend_forum_item_layout) {
            dk dkVar = (dk) view.getTag();
            if (dkVar != null) {
                String str7 = dkVar.name;
                str4 = this.aBu.aAx;
                if (str7.equals(str4)) {
                    buVar27 = this.aBu.aAF;
                    if (buVar27.getSlidingMenu().isMenuShowing()) {
                        buVar28 = this.aBu.aAF;
                        buVar28.getSlidingMenu().toggle(true);
                        return;
                    }
                    return;
                }
                this.aBu.aAG = "sidebar";
                this.aBu.aAH = dkVar.aET;
                this.aBu.fg(str7);
            }
        } else if (id == com.baidu.tieba.v.frs_header_groups) {
            bVar13 = this.aBu.azN;
            if (bVar13 != null) {
                bVar14 = this.aBu.azN;
                if (bVar14.zL() != null) {
                    bVar15 = this.aBu.azN;
                    if (!com.baidu.adp.lib.util.l.aA(bVar15.zL().getId())) {
                        bVar16 = this.aBu.azN;
                        if (bVar16.Fi() != null) {
                            TiebaStatic.eventStat(this.aBu, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity3 = this.aBu;
                            bVar17 = this.aBu.azN;
                            String id2 = bVar17.zL().getId();
                            bVar18 = this.aBu.azN;
                            this.aBu.sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(frsActivity3, id2, bVar18.Fi().yu() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.frs_header_games) {
            TiebaStatic.eventStat(this.aBu, "frs_ourgame", "click", 1, new Object[0]);
            bVar10 = this.aBu.azN;
            if (bVar10 != null) {
                bVar11 = this.aBu.azN;
                if (bVar11.EZ() != null) {
                    bVar12 = this.aBu.azN;
                    String EZ = bVar12.EZ();
                    int dl = com.baidu.tbadk.game.a.dl(EZ);
                    if (dl == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aBu, null, EZ, true)));
                    } else if (dl == 1) {
                        String dm = com.baidu.tbadk.game.a.dm(EZ);
                        if (!TextUtils.isEmpty(dm)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aBu, dm)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.btn_love_content) {
            buVar23 = this.aBu.aAF;
            if (!buVar23.Gn()) {
                z7 = this.aBu.aAT;
                if (!z7) {
                    buVar24 = this.aBu.aAF;
                    if (buVar24 != null) {
                        str2 = this.aBu.mPageType;
                        if (str2.equals("normal_page")) {
                            buVar26 = this.aBu.aAF;
                            buVar26.B(view);
                            return;
                        }
                        str3 = this.aBu.mPageType;
                        if (str3.equals("frs_page")) {
                            buVar25 = this.aBu.aAF;
                            buVar25.C(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.frs_new_guide) {
            SharedPreferences.Editor edit = this.aBu.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean("has_shown_frs_guide", true);
            edit.commit();
            buVar22 = this.aBu.aAF;
            buVar22.GI();
        } else if (id == com.baidu.tieba.v.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                bVar = this.aBu.azN;
                if (bVar != null) {
                    bVar2 = this.aBu.azN;
                    if (bVar2.zL() != null) {
                        bVar3 = this.aBu.azN;
                        if (bVar3.zL().getAnchorPower() != null) {
                            bVar4 = this.aBu.azN;
                            if (bVar4.zL().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.j.l(this.aBu.getBaseContext(), "start_live_bt");
                                if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    FrsActivity frsActivity4 = this.aBu;
                                    bVar8 = this.aBu.azN;
                                    int f = com.baidu.adp.lib.g.c.f(bVar8.zL().getId(), 0);
                                    bVar9 = this.aBu.azN;
                                    messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(frsActivity4, f, bVar9.zL().getName())));
                                    return;
                                }
                                MessageManager messageManager2 = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.aBu;
                                bVar6 = this.aBu.azN;
                                int f2 = com.baidu.adp.lib.g.c.f(bVar6.zL().getId(), 0);
                                bVar7 = this.aBu.azN;
                                messageManager2.sendMessage(new CustomMessage(2002001, new BackupLiveRoomEntranceActivityConfig(frsActivity5, f2, bVar7.zL().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.aBu;
                            bVar5 = this.aBu.azN;
                            frsActivity6.showToast(bVar5.zL().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aBu.showToast(com.baidu.tieba.y.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aBu.showToast(com.baidu.tieba.y.live_error_system_not_support);
        }
    }
}
