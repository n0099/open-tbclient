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
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
        if (r12 == r3.GL().Hx()) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (r12 == r3.GK().Hx()) goto L7;
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
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aDT.getPageContext().getPageActivity());
        bpVar = this.aDT.aCV;
        if (bpVar.GK() != null) {
            bpVar38 = this.aDT.aCV;
            if (view != bpVar38.GK().Hw()) {
                bpVar39 = this.aDT.aCV;
            }
            MessageManager messageManager = MessageManager.getInstance();
            Activity pageActivity = this.aDT.getPageContext().getPageActivity();
            eVar22 = this.aDT.aDf;
            messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, eVar22.aeI().getId(), ForumDetailActivityConfig.FromType.FRS)));
            return;
        }
        bpVar2 = this.aDT.aCV;
        if (bpVar2.GL() != null) {
            bpVar36 = this.aDT.aCV;
            if (view != bpVar36.GL().Hw()) {
                bpVar37 = this.aDT.aCV;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            Activity pageActivity2 = this.aDT.getPageContext().getPageActivity();
            eVar21 = this.aDT.aDf;
            messageManager2.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity2, eVar21.aeI().getId(), ForumDetailActivityConfig.FromType.FRS)));
            return;
        }
        bpVar3 = this.aDT.aCV;
        if (view != bpVar3.GC()) {
            bpVar4 = this.aDT.aCV;
            if (view == bpVar4.Gy()) {
                bpVar23 = this.aDT.aCV;
                z6 = this.aDT.aDd;
                bpVar23.bO(z6);
                TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bpVar5 = this.aDT.aCV;
                if (view != bpVar5.GD()) {
                    bpVar6 = this.aDT.aCV;
                    if (view == bpVar6.getMoreButton()) {
                        bpVar19 = this.aDT.aCV;
                        cyVar = this.aDT.aDi;
                        z3 = FrsActivity.aCK;
                        z4 = FrsActivity.aCL;
                        z5 = FrsActivity.aCM;
                        bpVar19.a(cyVar, z3, z4, z5);
                        TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bpVar20 = this.aDT.aCV;
                        bpVar20.Hd();
                        bpVar21 = this.aDT.aCV;
                        bpVar21.FB();
                        FrsActivity.aCK = false;
                        bpVar22 = this.aDT.aCV;
                        bpVar22.showMenu(true);
                    } else {
                        bpVar7 = this.aDT.aCV;
                        if (view == bpVar7.Gz()) {
                            bpVar16 = this.aDT.aCV;
                            bpVar16.Gv();
                            bpVar17 = this.aDT.aCV;
                            if (bpVar17.GG().isMenuShowing()) {
                                bpVar18 = this.aDT.aCV;
                                bpVar18.GG().toggle(true);
                            }
                            z2 = this.aDT.aDd;
                            if (z2) {
                                this.aDT.aDd = false;
                                this.aDT.refresh();
                            }
                        } else {
                            bpVar8 = this.aDT.aCV;
                            if (view != bpVar8.GA()) {
                                bpVar9 = this.aDT.aCV;
                                if (view != bpVar9.GB()) {
                                    bpVar10 = this.aDT.aCV;
                                    FrsHeaderView GK = bpVar10.GK();
                                    bpVar11 = this.aDT.aCV;
                                    com.baidu.tieba.frs.view.o GL = bpVar11.GL();
                                    if ((GK != null && GK.z(view)) || (GL != null && GL.z(view))) {
                                        com.baidu.tbadk.core.i.A(this.aDT.getParent(), "forum_fortune_click");
                                        if (!TbadkCoreApplication.isLogin()) {
                                            this.aDT.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aDT.getPageContext().getPageActivity(), (String) null, true, 18004)));
                                        } else {
                                            this.aDT.FX();
                                        }
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bpVar12 = this.aDT.aCV;
                                    bpVar12.Gv();
                                    FrsActivity frsActivity = this.aDT;
                                    FrsActivity frsActivity2 = this.aDT;
                                    str = this.aDT.aCN;
                                    frsActivity.aDo = new ax(frsActivity2, str);
                                    axVar = this.aDT.aDo;
                                    axVar.setSelfExecute(true);
                                    axVar2 = this.aDT.aDo;
                                    axVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bpVar13 = this.aDT.aCV;
                                bpVar13.Gv();
                                bpVar14 = this.aDT.aCV;
                                if (bpVar14.GG().isMenuShowing()) {
                                    bpVar15 = this.aDT.aCV;
                                    bpVar15.GG().toggle(true);
                                }
                                z = this.aDT.aDd;
                                if (!z) {
                                    this.aDT.aDd = true;
                                    this.aDT.refresh();
                                }
                            }
                        }
                    }
                } else {
                    this.aDT.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aDT.eI(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.w.btn_love) {
            bpVar35 = this.aDT.aCV;
            if (!bpVar35.GJ() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aDT.kw();
            }
        } else if (id == com.baidu.tieba.w.btn_sign) {
            bpVar33 = this.aDT.aCV;
            if (!bpVar33.GJ() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                bpVar34 = this.aDT.aCV;
                if (!bpVar34.GV()) {
                    this.aDT.FZ();
                }
            }
        } else if (id == com.baidu.tieba.w.refresh_layout) {
            TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bpVar31 = this.aDT.aCV;
            bpVar31.FB();
            bpVar32 = this.aDT.aCV;
            bpVar32.jC();
        } else if (id == com.baidu.tieba.w.message_layout) {
            FrsActivity.aCK = false;
            FrsActivity.aCL = false;
            this.aDT.FP();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.aDT.sendMessage(new CustomMessage(2002001, new ChatMessageActivityConfig(this.aDT.getPageContext().getPageActivity())));
            }
        } else if (id == com.baidu.tieba.w.mention_layout) {
            FrsActivity.aCK = false;
            FrsActivity.aCM = false;
            this.aDT.FP();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                this.aDT.sendMessage(new CustomMessage(2002001, new SingleMentionActivityConfig(this.aDT.getPageContext().getPageActivity())));
            }
        } else if (id == com.baidu.tieba.w.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aDT.getPageContext().getPageActivity())));
        } else if (id == com.baidu.tieba.w.bar_info_layout) {
            MessageManager messageManager3 = MessageManager.getInstance();
            Activity pageActivity3 = this.aDT.getPageContext().getPageActivity();
            eVar20 = this.aDT.aDf;
            messageManager3.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity3, eVar20.aeI().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
        } else if (id == com.baidu.tieba.w.forum_manager_center) {
            String str6 = "";
            eVar17 = this.aDT.aDf;
            if (eVar17 != null) {
                eVar18 = this.aDT.aDf;
                if (eVar18.aeI() != null) {
                    eVar19 = this.aDT.aDf;
                    str6 = eVar19.aeI().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str5 = this.aDT.aCN;
            com.baidu.tbadk.browser.a.x(this.aDT.getPageContext().getPageActivity(), sb.append(str5).append("&fid=").append(str6).toString());
        } else if (id == com.baidu.tieba.w.recommend_forum_item_layout) {
            de deVar = (de) view.getTag();
            if (deVar != null) {
                String str7 = deVar.name;
                str4 = this.aDT.aCN;
                if (str7.equals(str4)) {
                    bpVar29 = this.aDT.aCV;
                    if (bpVar29.GG().isMenuShowing()) {
                        bpVar30 = this.aDT.aCV;
                        bpVar30.GG().toggle(true);
                        return;
                    }
                    return;
                }
                this.aDT.aCW = "sidebar";
                this.aDT.aCX = deVar.aHD;
                this.aDT.fB(str7);
            }
        } else if (id == com.baidu.tieba.w.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.ff()) {
                this.aDT.FY();
            } else {
                this.aDT.showToast(com.baidu.tieba.z.neterror);
            }
        } else if (id == com.baidu.tieba.w.frs_header_groups) {
            eVar11 = this.aDT.aDf;
            if (eVar11 != null) {
                eVar12 = this.aDT.aDf;
                if (eVar12.aeI() != null) {
                    eVar13 = this.aDT.aDf;
                    if (!com.baidu.adp.lib.util.k.isEmpty(eVar13.aeI().getId())) {
                        eVar14 = this.aDT.aDf;
                        if (eVar14.aeL() != null) {
                            TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                            Activity pageActivity4 = this.aDT.getPageContext().getPageActivity();
                            eVar15 = this.aDT.aDf;
                            String id2 = eVar15.aeI().getId();
                            eVar16 = this.aDT.aDf;
                            this.aDT.sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(pageActivity4, id2, eVar16.aeL().aeB() != 1)));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.frs_header_games) {
            eVar8 = this.aDT.aDf;
            if (eVar8 != null) {
                eVar9 = this.aDT.aDf;
                if (eVar9.aeF() != null) {
                    eVar10 = this.aDT.aDf;
                    String aeF = eVar10.aeF();
                    int cq = com.baidu.tbadk.core.util.u.cq(aeF);
                    if (cq == 2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aDT.getPageContext().getPageActivity(), null, aeF, true)));
                    } else if (cq == 1) {
                        String is = com.baidu.tieba.tbadkCore.util.k.is(aeF);
                        if (!TextUtils.isEmpty(is)) {
                            TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", is, "ref_id", "1000601");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aDT.getPageContext().getPageActivity(), is, "1000601")));
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.btn_love_content) {
            bpVar25 = this.aDT.aCV;
            if (!bpVar25.GJ()) {
                z7 = this.aDT.aDl;
                if (!z7) {
                    bpVar26 = this.aDT.aCV;
                    if (bpVar26 != null) {
                        str2 = this.aDT.mPageType;
                        if (str2.equals("normal_page")) {
                            bpVar28 = this.aDT.aCV;
                            bpVar28.w(view);
                            return;
                        }
                        str3 = this.aDT.mPageType;
                        if (str3.equals("frs_page")) {
                            bpVar27 = this.aDT.aCV;
                            bpVar27.x(view);
                        }
                    }
                }
            }
        } else if (id == com.baidu.tieba.w.frs_new_guide) {
            SharedPreferences.Editor edit = this.aDT.getPageContext().getPageActivity().getSharedPreferences(TbConfig.SETTINGFILE, 0).edit();
            edit.putBoolean("has_shown_frs_guide", true);
            edit.commit();
            bpVar24 = this.aDT.aCV;
            bpVar24.He();
        } else if (id == com.baidu.tieba.w.nb_item_live_text_btn) {
            if (Build.VERSION.SDK_INT >= 9) {
                eVar = this.aDT.aDf;
                if (eVar != null) {
                    eVar2 = this.aDT.aDf;
                    if (eVar2.aeI() != null) {
                        eVar3 = this.aDT.aDf;
                        if (eVar3.aeI().getAnchorPower() != null) {
                            eVar4 = this.aDT.aDf;
                            if (eVar4.aeI().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.i.A(this.aDT.getBaseContext(), "start_live_bt");
                                MessageManager messageManager4 = MessageManager.getInstance();
                                Activity pageActivity5 = this.aDT.getPageContext().getPageActivity();
                                eVar6 = this.aDT.aDf;
                                int i = com.baidu.adp.lib.g.c.toInt(eVar6.aeI().getId(), 0);
                                eVar7 = this.aDT.aDf;
                                messageManager4.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity5, i, eVar7.aeI().getName())));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aDT;
                            eVar5 = this.aDT.aDf;
                            frsActivity3.showToast(eVar5.aeI().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aDT.showToast(com.baidu.tieba.z.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aDT.showToast(com.baidu.tieba.z.live_error_system_not_support);
        }
    }
}
