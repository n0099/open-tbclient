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
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
        if (r12 == r3.GR().HD()) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (r12 == r3.GQ().HD()) goto L7;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        bp bpVar6;
        bp bpVar7;
        bp bpVar8;
        bp bpVar9;
        bp bpVar10;
        bp bpVar11;
        bp bpVar12;
        String str;
        ax axVar;
        ax axVar2;
        bp bpVar13;
        bp bpVar14;
        boolean z;
        bp bpVar15;
        bp bpVar16;
        bp bpVar17;
        boolean z2;
        bp bpVar18;
        bp bpVar19;
        cy cyVar;
        boolean z3;
        boolean z4;
        boolean z5;
        bp bpVar20;
        bp bpVar21;
        bp bpVar22;
        bp bpVar23;
        boolean z6;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        com.baidu.tieba.tbadkCore.e eVar6;
        com.baidu.tieba.tbadkCore.e eVar7;
        bp bpVar24;
        bp bpVar25;
        boolean z7;
        bp bpVar26;
        String str2;
        String str3;
        bp bpVar27;
        bp bpVar28;
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
        bp bpVar29;
        bp bpVar30;
        com.baidu.tieba.tbadkCore.e eVar17;
        String str5;
        com.baidu.tieba.tbadkCore.e eVar18;
        com.baidu.tieba.tbadkCore.e eVar19;
        com.baidu.tieba.tbadkCore.e eVar20;
        bp bpVar31;
        bp bpVar32;
        bp bpVar33;
        bp bpVar34;
        bp bpVar35;
        bp bpVar36;
        com.baidu.tieba.tbadkCore.e eVar21;
        bp bpVar37;
        bp bpVar38;
        com.baidu.tieba.tbadkCore.e eVar22;
        bp bpVar39;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aDW.getPageContext().getPageActivity());
        bpVar = this.aDW.aCY;
        if (bpVar.GQ() != null) {
            bpVar38 = this.aDW.aCY;
            if (view != bpVar38.GQ().HC()) {
                bpVar39 = this.aDW.aCY;
            }
            MessageManager messageManager = MessageManager.getInstance();
            Activity pageActivity = this.aDW.getPageContext().getPageActivity();
            eVar22 = this.aDW.aDi;
            messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, eVar22.aeN().getId(), ForumDetailActivityConfig.FromType.FRS)));
            return;
        }
        bpVar2 = this.aDW.aCY;
        if (bpVar2.GR() != null) {
            bpVar36 = this.aDW.aCY;
            if (view != bpVar36.GR().HC()) {
                bpVar37 = this.aDW.aCY;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            Activity pageActivity2 = this.aDW.getPageContext().getPageActivity();
            eVar21 = this.aDW.aDi;
            messageManager2.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity2, eVar21.aeN().getId(), ForumDetailActivityConfig.FromType.FRS)));
            return;
        }
        bpVar3 = this.aDW.aCY;
        if (view != bpVar3.GI()) {
            bpVar4 = this.aDW.aCY;
            if (view == bpVar4.GE()) {
                bpVar23 = this.aDW.aCY;
                z6 = this.aDW.aDg;
                bpVar23.bO(z6);
                TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bpVar5 = this.aDW.aCY;
                if (view != bpVar5.GJ()) {
                    bpVar6 = this.aDW.aCY;
                    if (view == bpVar6.getMoreButton()) {
                        bpVar19 = this.aDW.aCY;
                        cyVar = this.aDW.aDl;
                        z3 = FrsActivity.aCN;
                        z4 = FrsActivity.aCO;
                        z5 = FrsActivity.aCP;
                        bpVar19.a(cyVar, z3, z4, z5);
                        TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bpVar20 = this.aDW.aCY;
                        bpVar20.Hj();
                        bpVar21 = this.aDW.aCY;
                        bpVar21.FH();
                        FrsActivity.aCN = false;
                        bpVar22 = this.aDW.aCY;
                        bpVar22.showMenu(true);
                    } else {
                        bpVar7 = this.aDW.aCY;
                        if (view == bpVar7.GF()) {
                            bpVar16 = this.aDW.aCY;
                            bpVar16.GB();
                            bpVar17 = this.aDW.aCY;
                            if (bpVar17.GM().isMenuShowing()) {
                                bpVar18 = this.aDW.aCY;
                                bpVar18.GM().toggle(true);
                            }
                            z2 = this.aDW.aDg;
                            if (z2) {
                                this.aDW.aDg = false;
                                this.aDW.refresh();
                            }
                        } else {
                            bpVar8 = this.aDW.aCY;
                            if (view != bpVar8.GG()) {
                                bpVar9 = this.aDW.aCY;
                                if (view != bpVar9.GH()) {
                                    bpVar10 = this.aDW.aCY;
                                    FrsHeaderView GQ = bpVar10.GQ();
                                    bpVar11 = this.aDW.aCY;
                                    com.baidu.tieba.frs.view.o GR = bpVar11.GR();
                                    if ((GQ != null && GQ.z(view)) || (GR != null && GR.z(view))) {
                                        com.baidu.tbadk.core.i.A(this.aDW.getParent(), "forum_fortune_click");
                                        if (!TbadkCoreApplication.isLogin()) {
                                            this.aDW.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aDW.getPageContext().getPageActivity(), (String) null, true, 18004)));
                                        } else {
                                            this.aDW.Gd();
                                        }
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bpVar12 = this.aDW.aCY;
                                    bpVar12.GB();
                                    FrsActivity frsActivity = this.aDW;
                                    FrsActivity frsActivity2 = this.aDW;
                                    str = this.aDW.aCQ;
                                    frsActivity.aDr = new ax(frsActivity2, str);
                                    axVar = this.aDW.aDr;
                                    axVar.setSelfExecute(true);
                                    axVar2 = this.aDW.aDr;
                                    axVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bpVar13 = this.aDW.aCY;
                                bpVar13.GB();
                                bpVar14 = this.aDW.aCY;
                                if (bpVar14.GM().isMenuShowing()) {
                                    bpVar15 = this.aDW.aCY;
                                    bpVar15.GM().toggle(true);
                                }
                                z = this.aDW.aDg;
                                if (!z) {
                                    this.aDW.aDg = true;
                                    this.aDW.refresh();
                                }
                            }
                        }
                    }
                } else {
                    this.aDW.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aDW.eI(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.w.btn_love) {
            bpVar35 = this.aDW.aCY;
            if (!bpVar35.GP() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aDW.kD();
            }
        } else if (id == com.baidu.tieba.w.btn_sign) {
            bpVar33 = this.aDW.aCY;
            if (!bpVar33.GP() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                bpVar34 = this.aDW.aCY;
                if (!bpVar34.Hb()) {
                    this.aDW.Gf();
                }
            }
        } else if (id == com.baidu.tieba.w.refresh_layout) {
            TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bpVar31 = this.aDW.aCY;
            bpVar31.FH();
            bpVar32 = this.aDW.aCY;
            bpVar32.jJ();
        } else if (id == com.baidu.tieba.w.message_layout) {
            FrsActivity.aCN = false;
            FrsActivity.aCO = false;
            this.aDW.FV();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.aDW.sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(this.aDW.getPageContext().getPageActivity())));
            }
        } else if (id == com.baidu.tieba.w.mention_layout) {
            FrsActivity.aCN = false;
            FrsActivity.aCP = false;
            this.aDW.FV();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                this.aDW.sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(this.aDW.getPageContext().getPageActivity())));
            }
        } else if (id == com.baidu.tieba.w.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aDW.getPageContext().getPageActivity())));
        } else if (id == com.baidu.tieba.w.bar_info_layout) {
            MessageManager messageManager3 = MessageManager.getInstance();
            Activity pageActivity3 = this.aDW.getPageContext().getPageActivity();
            eVar20 = this.aDW.aDi;
            messageManager3.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity3, eVar20.aeN().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
        } else if (id == com.baidu.tieba.w.forum_manager_center) {
            String str6 = "";
            eVar17 = this.aDW.aDi;
            if (eVar17 != null) {
                eVar18 = this.aDW.aDi;
                if (eVar18.aeN() != null) {
                    eVar19 = this.aDW.aDi;
                    str6 = eVar19.aeN().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str5 = this.aDW.aCQ;
            com.baidu.tbadk.browser.a.x(this.aDW.getPageContext().getPageActivity(), sb.append(str5).append("&fid=").append(str6).toString());
        } else if (id == com.baidu.tieba.w.recommend_forum_item_layout) {
            de deVar = (de) view.getTag();
            if (deVar != null) {
                String str7 = deVar.name;
                str4 = this.aDW.aCQ;
                if (str7.equals(str4)) {
                    bpVar29 = this.aDW.aCY;
                    if (bpVar29.GM().isMenuShowing()) {
                        bpVar30 = this.aDW.aCY;
                        bpVar30.GM().toggle(true);
                        return;
                    }
                    return;
                }
                this.aDW.aCZ = "sidebar";
                this.aDW.aDa = deVar.aHG;
                this.aDW.fE(str7);
            }
        } else if (id == com.baidu.tieba.w.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.ff()) {
                this.aDW.Ge();
            } else {
                this.aDW.showToast(com.baidu.tieba.z.neterror);
            }
        } else if (id == com.baidu.tieba.w.frs_header_groups) {
            eVar11 = this.aDW.aDi;
            if (eVar11 != null) {
                eVar12 = this.aDW.aDi;
                if (eVar12.aeN() != null) {
                    eVar13 = this.aDW.aDi;
                    if (!com.baidu.adp.lib.util.k.isEmpty(eVar13.aeN().getId())) {
                        eVar14 = this.aDW.aDi;
                        if (eVar14.aeQ() != null) {
                            TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                            Activity pageActivity4 = this.aDW.getPageContext().getPageActivity();
                            eVar15 = this.aDW.aDi;
                            String id2 = eVar15.aeN().getId();
                            eVar16 = this.aDW.aDi;
                            this.aDW.sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(pageActivity4, id2, eVar16.aeQ().aeG() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.frs_header_games) {
            eVar8 = this.aDW.aDi;
            if (eVar8 != null) {
                eVar9 = this.aDW.aDi;
                if (eVar9.aeK() != null) {
                    eVar10 = this.aDW.aDi;
                    String aeK = eVar10.aeK();
                    int ct = com.baidu.tbadk.core.util.u.ct(aeK);
                    if (ct == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aDW.getPageContext().getPageActivity(), null, aeK, true)));
                    } else if (ct == 1) {
                        String iu = com.baidu.tieba.tbadkCore.util.k.iu(aeK);
                        if (!TextUtils.isEmpty(iu)) {
                            TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", iu, "ref_id", "1000601");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aDW.getPageContext().getPageActivity(), iu, "1000601")));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.btn_love_content) {
            bpVar25 = this.aDW.aCY;
            if (!bpVar25.GP()) {
                z7 = this.aDW.aDo;
                if (!z7) {
                    bpVar26 = this.aDW.aCY;
                    if (bpVar26 != null) {
                        str2 = this.aDW.mPageType;
                        if (str2.equals("normal_page")) {
                            bpVar28 = this.aDW.aCY;
                            bpVar28.w(view);
                            return;
                        }
                        str3 = this.aDW.mPageType;
                        if (str3.equals("frs_page")) {
                            bpVar27 = this.aDW.aCY;
                            bpVar27.x(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.frs_new_guide) {
            SharedPreferences.Editor edit = this.aDW.getPageContext().getPageActivity().getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean("has_shown_frs_guide", true);
            edit.commit();
            bpVar24 = this.aDW.aCY;
            bpVar24.Hk();
        } else if (id == com.baidu.tieba.w.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                eVar = this.aDW.aDi;
                if (eVar != null) {
                    eVar2 = this.aDW.aDi;
                    if (eVar2.aeN() != null) {
                        eVar3 = this.aDW.aDi;
                        if (eVar3.aeN().getAnchorPower() != null) {
                            eVar4 = this.aDW.aDi;
                            if (eVar4.aeN().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.i.A(this.aDW.getBaseContext(), "start_live_bt");
                                MessageManager messageManager4 = MessageManager.getInstance();
                                Activity pageActivity5 = this.aDW.getPageContext().getPageActivity();
                                eVar6 = this.aDW.aDi;
                                int i = com.baidu.adp.lib.g.c.toInt(eVar6.aeN().getId(), 0);
                                eVar7 = this.aDW.aDi;
                                messageManager4.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity5, i, eVar7.aeN().getName())));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aDW;
                            eVar5 = this.aDW.aDi;
                            frsActivity3.showToast(eVar5.aeN().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aDW.showToast(com.baidu.tieba.z.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aDW.showToast(com.baidu.tieba.z.live_error_system_not_support);
        }
    }
}
