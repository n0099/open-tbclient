package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
class ck implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cr crVar;
        cr crVar2;
        cr crVar3;
        cr crVar4;
        cr crVar5;
        cr crVar6;
        cr crVar7;
        cr crVar8;
        cr crVar9;
        String str;
        cp cpVar;
        cp cpVar2;
        cr crVar10;
        cr crVar11;
        String str2;
        String str3;
        cr crVar12;
        String str4;
        String str5;
        cr crVar13;
        cr crVar14;
        String str6;
        cr crVar15;
        cr crVar16;
        dm dmVar;
        String str7;
        dm dmVar2;
        dm dmVar3;
        crVar = this.a.o;
        if (view != crVar.f()) {
            crVar2 = this.a.o;
            if (view != crVar2.d()) {
                crVar3 = this.a.o;
                if (view == crVar3.e()) {
                    this.a.closeActivity();
                } else {
                    crVar4 = this.a.o;
                    if (view != crVar4.g()) {
                        crVar5 = this.a.o;
                        if (view == crVar5.h()) {
                            crVar12 = this.a.o;
                            crVar12.c();
                            this.a.r = false;
                            TbadkApplication m252getInst = TbadkApplication.m252getInst();
                            str4 = this.a.f;
                            m252getInst.delFrsImageForum(str4);
                            FrsImageActivity frsImageActivity = this.a;
                            com.baidu.tbadk.core.atomData.s sVar = new com.baidu.tbadk.core.atomData.s(this.a);
                            str5 = this.a.f;
                            frsImageActivity.sendMessage(new CustomMessage(2003000, sVar.a(str5, null)));
                            this.a.a();
                        } else {
                            crVar6 = this.a.o;
                            if (view == crVar6.i()) {
                                crVar11 = this.a.o;
                                crVar11.c();
                                this.a.r = false;
                                TiebaStatic.eventStat(this.a, "frs_good", "frsclick", 1, new Object[0]);
                                TbadkApplication m252getInst2 = TbadkApplication.m252getInst();
                                str2 = this.a.f;
                                m252getInst2.delFrsImageForum(str2);
                                FrsImageActivity frsImageActivity2 = this.a;
                                com.baidu.tbadk.core.atomData.s sVar2 = new com.baidu.tbadk.core.atomData.s(this.a);
                                str3 = this.a.f;
                                frsImageActivity2.sendMessage(new CustomMessage(2003000, sVar2.b(str3, null)));
                                this.a.a();
                            } else {
                                crVar7 = this.a.o;
                                if (view == crVar7.j()) {
                                    crVar10 = this.a.o;
                                    crVar10.c();
                                } else {
                                    crVar8 = this.a.o;
                                    if (view == crVar8.k()) {
                                        crVar9 = this.a.o;
                                        crVar9.c();
                                        TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                        FrsImageActivity frsImageActivity3 = this.a;
                                        FrsImageActivity frsImageActivity4 = this.a;
                                        str = this.a.f;
                                        frsImageActivity3.y = new cp(frsImageActivity4, str);
                                        cpVar = this.a.y;
                                        cpVar.setSelfExecute(true);
                                        cpVar2 = this.a.y;
                                        cpVar2.execute(new String[0]);
                                    }
                                }
                            }
                        }
                    } else {
                        FrsImageActivity.a = false;
                        crVar13 = this.a.o;
                        crVar13.b();
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        crVar14 = this.a.o;
                        crVar14.b(true);
                    }
                }
            } else {
                this.a.n();
            }
        } else {
            this.a.a(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.u.message_layout) {
            FrsImageActivity.a = false;
            FrsImageActivity.b = false;
            this.a.k();
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.h(this.a)));
            }
        } else if (id == com.baidu.tieba.u.mention_layout) {
            FrsImageActivity.a = false;
            FrsImageActivity.c = false;
            this.a.k();
            String currentAccount2 = TbadkApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bw((Context) this.a, false)));
            }
        } else if (id == com.baidu.tieba.u.forum_manager_center) {
            String str8 = "";
            dmVar = this.a.t;
            if (dmVar != null) {
                dmVar2 = this.a.t;
                if (dmVar2.b() != null) {
                    dmVar3 = this.a.t;
                    str8 = dmVar3.b().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str7 = this.a.f;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str7).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.u.recommend_forum_item_layout) {
            TiebaStatic.eventStat(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str9 = (String) view.getTag();
            str6 = this.a.f;
            if (str9.equals(str6)) {
                this.a.r = false;
                crVar15 = this.a.o;
                if (crVar15.n().isMenuShowing()) {
                    crVar16 = this.a.o;
                    crVar16.n().toggle(true);
                    return;
                }
                return;
            }
            this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.a).a(str9, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
            this.a.a();
        }
    }
}
