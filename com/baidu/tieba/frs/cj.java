package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
class cj implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cp cpVar;
        cp cpVar2;
        cp cpVar3;
        cp cpVar4;
        cp cpVar5;
        cp cpVar6;
        cp cpVar7;
        cp cpVar8;
        cp cpVar9;
        String str;
        cp cpVar10;
        cp cpVar11;
        String str2;
        String str3;
        cp cpVar12;
        String str4;
        String str5;
        cp cpVar13;
        cp cpVar14;
        String str6;
        cp cpVar15;
        cp cpVar16;
        dh dhVar;
        String str7;
        dh dhVar2;
        dh dhVar3;
        cpVar = this.a.o;
        if (view != cpVar.f()) {
            cpVar2 = this.a.o;
            if (view != cpVar2.d()) {
                cpVar3 = this.a.o;
                if (view == cpVar3.e()) {
                    this.a.closeActivity();
                } else {
                    cpVar4 = this.a.o;
                    if (view != cpVar4.g()) {
                        cpVar5 = this.a.o;
                        if (view == cpVar5.h()) {
                            cpVar12 = this.a.o;
                            cpVar12.c();
                            this.a.r = false;
                            TbadkApplication m252getInst = TbadkApplication.m252getInst();
                            str4 = this.a.e;
                            m252getInst.delFrsImageForum(str4);
                            FrsImageActivity frsImageActivity = this.a;
                            com.baidu.tbadk.core.atomData.m mVar = new com.baidu.tbadk.core.atomData.m(this.a);
                            str5 = this.a.e;
                            frsImageActivity.sendMessage(new CustomMessage(2005000, mVar.a(str5, null)));
                            this.a.a();
                        } else {
                            cpVar6 = this.a.o;
                            if (view == cpVar6.i()) {
                                cpVar11 = this.a.o;
                                cpVar11.c();
                                this.a.r = false;
                                TiebaStatic.eventStat(this.a, "frs_good", "frsclick", 1, new Object[0]);
                                TbadkApplication m252getInst2 = TbadkApplication.m252getInst();
                                str2 = this.a.e;
                                m252getInst2.delFrsImageForum(str2);
                                FrsImageActivity frsImageActivity2 = this.a;
                                com.baidu.tbadk.core.atomData.m mVar2 = new com.baidu.tbadk.core.atomData.m(this.a);
                                str3 = this.a.e;
                                frsImageActivity2.sendMessage(new CustomMessage(2005000, mVar2.b(str3, null)));
                                this.a.a();
                            } else {
                                cpVar7 = this.a.o;
                                if (view == cpVar7.j()) {
                                    cpVar10 = this.a.o;
                                    cpVar10.c();
                                } else {
                                    cpVar8 = this.a.o;
                                    if (view == cpVar8.k()) {
                                        cpVar9 = this.a.o;
                                        cpVar9.c();
                                        FrsImageActivity frsImageActivity3 = this.a;
                                        str = this.a.e;
                                        frsImageActivity3.b(str);
                                    }
                                }
                            }
                        }
                    } else {
                        FrsImageActivity.a = false;
                        cpVar13 = this.a.o;
                        cpVar13.b();
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        cpVar14 = this.a.o;
                        cpVar14.b(true);
                    }
                }
            } else {
                this.a.n();
            }
        } else {
            this.a.a(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.r.message_layout) {
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new CustomMessage(2017003, new com.baidu.tbadk.core.frameworkData.a(this.a)));
            }
        } else if (id == com.baidu.tieba.r.forum_manager_center) {
            String str8 = "";
            dhVar = this.a.t;
            if (dhVar != null) {
                dhVar2 = this.a.t;
                if (dhVar2.b() != null) {
                    dhVar3 = this.a.t;
                    str8 = dhVar3.b().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str7 = this.a.e;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str7).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.r.recommend_forum_item_layout) {
            TiebaStatic.eventStat(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str9 = (String) view.getTag();
            str6 = this.a.e;
            if (str9.equals(str6)) {
                this.a.r = false;
                cpVar15 = this.a.o;
                if (cpVar15.n().isMenuShowing()) {
                    cpVar16 = this.a.o;
                    cpVar16.n().toggle(true);
                    return;
                }
                return;
            }
            this.a.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.a).a(str9, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
            this.a.a();
        }
    }
}
