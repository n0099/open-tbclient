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
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aBk = frsActivity;
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
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aBk);
        buVar = this.aBk.aAv;
        if (view != buVar.Ge()) {
            buVar2 = this.aBk.aAv;
            if (view == buVar2.Ga()) {
                buVar21 = this.aBk.aAv;
                z6 = this.aBk.aAD;
                buVar21.ca(z6);
                TiebaStatic.eventStat(this.aBk, "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                buVar3 = this.aBk.aAv;
                if (view != buVar3.Gg()) {
                    buVar4 = this.aBk.aAv;
                    if (view == buVar4.Gf()) {
                        buVar17 = this.aBk.aAv;
                        czVar = this.aBk.aAH;
                        z3 = FrsActivity.aAk;
                        z4 = FrsActivity.aAl;
                        z5 = FrsActivity.aAm;
                        buVar17.a(czVar, z3, z4, z5);
                        TiebaStatic.eventStat(this.aBk, "frs_more", "frsclick", 1, new Object[0]);
                        buVar18 = this.aBk.aAv;
                        buVar18.GF();
                        buVar19 = this.aBk.aAv;
                        buVar19.EP();
                        FrsActivity.aAk = false;
                        buVar20 = this.aBk.aAv;
                        buVar20.showMenu(true);
                    } else {
                        buVar5 = this.aBk.aAv;
                        if (view == buVar5.Gb()) {
                            buVar14 = this.aBk.aAv;
                            buVar14.FX();
                            buVar15 = this.aBk.aAv;
                            if (buVar15.getSlidingMenu().isMenuShowing()) {
                                buVar16 = this.aBk.aAv;
                                buVar16.getSlidingMenu().toggle(true);
                            }
                            z2 = this.aBk.aAD;
                            if (z2) {
                                this.aBk.aAD = false;
                                this.aBk.refresh();
                            }
                        } else {
                            buVar6 = this.aBk.aAv;
                            if (view != buVar6.Gc()) {
                                buVar7 = this.aBk.aAv;
                                if (view != buVar7.Gd()) {
                                    buVar8 = this.aBk.aAv;
                                    FrsHeaderView Gm = buVar8.Gm();
                                    buVar9 = this.aBk.aAv;
                                    com.baidu.tieba.frs.view.r Gn = buVar9.Gn();
                                    if ((Gm != null && Gm.E(view)) || (Gn != null && Gn.E(view))) {
                                        com.baidu.tbadk.core.i.l(this.aBk.getParent(), "forum_fortune_click");
                                        if (!TbadkApplication.isLogin()) {
                                            LoginActivity.a((Activity) this.aBk, (String) null, true, 18004);
                                        } else {
                                            this.aBk.Fy();
                                        }
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.aBk, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    buVar10 = this.aBk.aAv;
                                    buVar10.FX();
                                    FrsActivity frsActivity = this.aBk;
                                    FrsActivity frsActivity2 = this.aBk;
                                    str = this.aBk.aAn;
                                    frsActivity.aAL = new bc(frsActivity2, str);
                                    bcVar = this.aBk.aAL;
                                    bcVar.setSelfExecute(true);
                                    bcVar2 = this.aBk.aAL;
                                    bcVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aBk, "frs_good_threads", "frsclick", 1, new Object[0]);
                                buVar11 = this.aBk.aAv;
                                buVar11.FX();
                                buVar12 = this.aBk.aAv;
                                if (buVar12.getSlidingMenu().isMenuShowing()) {
                                    buVar13 = this.aBk.aAv;
                                    buVar13.getSlidingMenu().toggle(true);
                                }
                                z = this.aBk.aAD;
                                if (!z) {
                                    this.aBk.aAD = true;
                                    this.aBk.refresh();
                                }
                            }
                        }
                    }
                } else {
                    this.aBk.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aBk, "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aBk.eE(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.v.btn_love) {
            buVar33 = this.aBk.aAv;
            if (!buVar33.Gl() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aBk.Fz();
            }
        } else if (id == com.baidu.tieba.v.btn_sign) {
            buVar31 = this.aBk.aAv;
            if (!buVar31.Gl() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                buVar32 = this.aBk.aAv;
                if (!buVar32.Gx()) {
                    this.aBk.FB();
                }
            }
        } else if (id == com.baidu.tieba.v.refresh_layout) {
            TiebaStatic.eventStat(this.aBk, "frs_refresh", "frsclick", 1, new Object[0]);
            buVar29 = this.aBk.aAv;
            buVar29.EP();
            buVar30 = this.aBk.aAv;
            buVar30.hO();
        } else if (id == com.baidu.tieba.v.message_layout) {
            FrsActivity.aAk = false;
            FrsActivity.aAl = false;
            this.aBk.Fq();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.aBk.sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(this.aBk)));
            }
        } else if (id == com.baidu.tieba.v.mention_layout) {
            FrsActivity.aAk = false;
            FrsActivity.aAm = false;
            this.aBk.Fq();
            String currentAccount2 = TbadkApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aBk, "frs_message", "frsclick", 1, new Object[0]);
                this.aBk.sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig((Context) this.aBk, false)));
            }
        } else if (id == com.baidu.tieba.v.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aBk)));
        } else if (id == com.baidu.tieba.v.forum_manager_center) {
            String str6 = "";
            bVar19 = this.aBk.azE;
            if (bVar19 != null) {
                bVar20 = this.aBk.azE;
                if (bVar20.zJ() != null) {
                    bVar21 = this.aBk.azE;
                    str6 = bVar21.zJ().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str5 = this.aBk.aAn;
            com.baidu.tbadk.browser.a.i(this.aBk, sb.append(str5).append("&fid=").append(str6).toString());
        } else if (id == com.baidu.tieba.v.recommend_forum_item_layout) {
            dk dkVar = (dk) view.getTag();
            if (dkVar != null) {
                String str7 = dkVar.name;
                str4 = this.aBk.aAn;
                if (str7.equals(str4)) {
                    buVar27 = this.aBk.aAv;
                    if (buVar27.getSlidingMenu().isMenuShowing()) {
                        buVar28 = this.aBk.aAv;
                        buVar28.getSlidingMenu().toggle(true);
                        return;
                    }
                    return;
                }
                this.aBk.aAw = "sidebar";
                this.aBk.aAx = dkVar.aEJ;
                this.aBk.fg(str7);
            }
        } else if (id == com.baidu.tieba.v.frs_header_groups) {
            bVar13 = this.aBk.azE;
            if (bVar13 != null) {
                bVar14 = this.aBk.azE;
                if (bVar14.zJ() != null) {
                    bVar15 = this.aBk.azE;
                    if (!com.baidu.adp.lib.util.l.aA(bVar15.zJ().getId())) {
                        bVar16 = this.aBk.azE;
                        if (bVar16.Fg() != null) {
                            TiebaStatic.eventStat(this.aBk, "im_e_glist_from_frs", "click", 1, new Object[0]);
                            FrsActivity frsActivity3 = this.aBk;
                            bVar17 = this.aBk.azE;
                            String id2 = bVar17.zJ().getId();
                            bVar18 = this.aBk.azE;
                            this.aBk.sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(frsActivity3, id2, bVar18.Fg().ys() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.frs_header_games) {
            TiebaStatic.eventStat(this.aBk, "frs_ourgame", "click", 1, new Object[0]);
            bVar10 = this.aBk.azE;
            if (bVar10 != null) {
                bVar11 = this.aBk.azE;
                if (bVar11.EX() != null) {
                    bVar12 = this.aBk.azE;
                    String EX = bVar12.EX();
                    int dl = com.baidu.tbadk.game.a.dl(EX);
                    if (dl == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aBk, null, EX, true)));
                    } else if (dl == 1) {
                        String dm = com.baidu.tbadk.game.a.dm(EX);
                        if (!TextUtils.isEmpty(dm)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aBk, dm)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.btn_love_content) {
            buVar23 = this.aBk.aAv;
            if (!buVar23.Gl()) {
                z7 = this.aBk.aAJ;
                if (!z7) {
                    buVar24 = this.aBk.aAv;
                    if (buVar24 != null) {
                        str2 = this.aBk.mPageType;
                        if (str2.equals("normal_page")) {
                            buVar26 = this.aBk.aAv;
                            buVar26.B(view);
                            return;
                        }
                        str3 = this.aBk.mPageType;
                        if (str3.equals("frs_page")) {
                            buVar25 = this.aBk.aAv;
                            buVar25.C(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.v.frs_new_guide) {
            SharedPreferences.Editor edit = this.aBk.getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean("has_shown_frs_guide", true);
            edit.commit();
            buVar22 = this.aBk.aAv;
            buVar22.GG();
        } else if (id == com.baidu.tieba.v.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                bVar = this.aBk.azE;
                if (bVar != null) {
                    bVar2 = this.aBk.azE;
                    if (bVar2.zJ() != null) {
                        bVar3 = this.aBk.azE;
                        if (bVar3.zJ().getAnchorPower() != null) {
                            bVar4 = this.aBk.azE;
                            if (bVar4.zJ().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.i.l(this.aBk.getBaseContext(), "start_live_bt");
                                if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    FrsActivity frsActivity4 = this.aBk;
                                    bVar8 = this.aBk.azE;
                                    int f = com.baidu.adp.lib.g.c.f(bVar8.zJ().getId(), 0);
                                    bVar9 = this.aBk.azE;
                                    messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(frsActivity4, f, bVar9.zJ().getName())));
                                    return;
                                }
                                MessageManager messageManager2 = MessageManager.getInstance();
                                FrsActivity frsActivity5 = this.aBk;
                                bVar6 = this.aBk.azE;
                                int f2 = com.baidu.adp.lib.g.c.f(bVar6.zJ().getId(), 0);
                                bVar7 = this.aBk.azE;
                                messageManager2.sendMessage(new CustomMessage(2002001, new BackupLiveRoomEntranceActivityConfig(frsActivity5, f2, bVar7.zJ().getName())));
                                return;
                            }
                            FrsActivity frsActivity6 = this.aBk;
                            bVar5 = this.aBk.azE;
                            frsActivity6.showToast(bVar5.zJ().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aBk.showToast(com.baidu.tieba.y.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aBk.showToast(com.baidu.tieba.y.live_error_system_not_support);
        }
    }
}
