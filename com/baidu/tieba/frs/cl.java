package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
class cl implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
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
        String str;
        cq cqVar;
        cq cqVar2;
        cs csVar10;
        cs csVar11;
        String str2;
        String str3;
        cs csVar12;
        String str4;
        String str5;
        cs csVar13;
        cs csVar14;
        String str6;
        cs csVar15;
        cs csVar16;
        Cdo cdo;
        String str7;
        Cdo cdo2;
        Cdo cdo3;
        csVar = this.a.o;
        if (view != csVar.f()) {
            csVar2 = this.a.o;
            if (view != csVar2.d()) {
                csVar3 = this.a.o;
                if (view == csVar3.e()) {
                    this.a.closeActivity();
                } else {
                    csVar4 = this.a.o;
                    if (view != csVar4.g()) {
                        csVar5 = this.a.o;
                        if (view == csVar5.h()) {
                            csVar12 = this.a.o;
                            csVar12.c();
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
                            csVar6 = this.a.o;
                            if (view == csVar6.i()) {
                                csVar11 = this.a.o;
                                csVar11.c();
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
                                csVar7 = this.a.o;
                                if (view == csVar7.j()) {
                                    csVar10 = this.a.o;
                                    csVar10.c();
                                } else {
                                    csVar8 = this.a.o;
                                    if (view == csVar8.k()) {
                                        csVar9 = this.a.o;
                                        csVar9.c();
                                        TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                        FrsImageActivity frsImageActivity3 = this.a;
                                        FrsImageActivity frsImageActivity4 = this.a;
                                        str = this.a.f;
                                        frsImageActivity3.y = new cq(frsImageActivity4, str);
                                        cqVar = this.a.y;
                                        cqVar.setSelfExecute(true);
                                        cqVar2 = this.a.y;
                                        cqVar2.execute(new String[0]);
                                    }
                                }
                            }
                        }
                    } else {
                        FrsImageActivity.a = false;
                        csVar13 = this.a.o;
                        csVar13.b();
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        csVar14 = this.a.o;
                        csVar14.b(true);
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
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bx((Context) this.a, false)));
            }
        } else if (id == com.baidu.tieba.u.forum_manager_center) {
            String str8 = "";
            cdo = this.a.t;
            if (cdo != null) {
                cdo2 = this.a.t;
                if (cdo2.b() != null) {
                    cdo3 = this.a.t;
                    str8 = cdo3.b().getId();
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
                csVar15 = this.a.o;
                if (csVar15.n().isMenuShowing()) {
                    csVar16 = this.a.o;
                    csVar16.n().toggle(true);
                    return;
                }
                return;
            }
            this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.a).a(str9, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
            this.a.a();
        }
    }
}
