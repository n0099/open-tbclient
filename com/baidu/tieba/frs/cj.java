package com.baidu.tieba.frs;

import android.content.Context;
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
        cq cqVar;
        cq cqVar2;
        cq cqVar3;
        cq cqVar4;
        cq cqVar5;
        cq cqVar6;
        cq cqVar7;
        cq cqVar8;
        cq cqVar9;
        String str;
        co coVar;
        co coVar2;
        cq cqVar10;
        cq cqVar11;
        String str2;
        String str3;
        cq cqVar12;
        String str4;
        String str5;
        cq cqVar13;
        cq cqVar14;
        String str6;
        cq cqVar15;
        cq cqVar16;
        dj djVar;
        String str7;
        dj djVar2;
        dj djVar3;
        Context context;
        cqVar = this.a.n;
        if (view != cqVar.f()) {
            cqVar2 = this.a.n;
            if (view != cqVar2.d()) {
                cqVar3 = this.a.n;
                if (view == cqVar3.e()) {
                    this.a.closeActivity();
                } else {
                    cqVar4 = this.a.n;
                    if (view != cqVar4.g()) {
                        cqVar5 = this.a.n;
                        if (view == cqVar5.h()) {
                            cqVar12 = this.a.n;
                            cqVar12.c();
                            this.a.q = false;
                            TbadkApplication m252getInst = TbadkApplication.m252getInst();
                            str4 = this.a.e;
                            m252getInst.delFrsImageForum(str4);
                            FrsImageActivity frsImageActivity = this.a;
                            com.baidu.tbadk.core.atomData.r rVar = new com.baidu.tbadk.core.atomData.r(this.a);
                            str5 = this.a.e;
                            frsImageActivity.sendMessage(new CustomMessage(2003000, rVar.a(str5, null)));
                            this.a.a();
                        } else {
                            cqVar6 = this.a.n;
                            if (view == cqVar6.i()) {
                                cqVar11 = this.a.n;
                                cqVar11.c();
                                this.a.q = false;
                                TiebaStatic.eventStat(this.a, "frs_good", "frsclick", 1, new Object[0]);
                                TbadkApplication m252getInst2 = TbadkApplication.m252getInst();
                                str2 = this.a.e;
                                m252getInst2.delFrsImageForum(str2);
                                FrsImageActivity frsImageActivity2 = this.a;
                                com.baidu.tbadk.core.atomData.r rVar2 = new com.baidu.tbadk.core.atomData.r(this.a);
                                str3 = this.a.e;
                                frsImageActivity2.sendMessage(new CustomMessage(2003000, rVar2.b(str3, null)));
                                this.a.a();
                            } else {
                                cqVar7 = this.a.n;
                                if (view == cqVar7.j()) {
                                    cqVar10 = this.a.n;
                                    cqVar10.c();
                                } else {
                                    cqVar8 = this.a.n;
                                    if (view == cqVar8.k()) {
                                        cqVar9 = this.a.n;
                                        cqVar9.c();
                                        TiebaStatic.eventStat(this.a, "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                        FrsImageActivity frsImageActivity3 = this.a;
                                        FrsImageActivity frsImageActivity4 = this.a;
                                        str = this.a.e;
                                        frsImageActivity3.x = new co(frsImageActivity4, str);
                                        coVar = this.a.x;
                                        coVar.setSelfExecute(true);
                                        coVar2 = this.a.x;
                                        coVar2.execute(new String[0]);
                                    }
                                }
                            }
                        }
                    } else {
                        FrsImageActivity.a = false;
                        cqVar13 = this.a.n;
                        cqVar13.b();
                        TiebaStatic.eventStat(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        cqVar14 = this.a.n;
                        cqVar14.b(true);
                    }
                }
            } else {
                this.a.n();
            }
        } else {
            this.a.a(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.v.message_layout) {
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                TiebaStatic.eventStat(this.a, "frs_message", "frsclick", 1, new Object[0]);
                context = this.a.A;
                this.a.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bn(context, true)));
            }
        } else if (id == com.baidu.tieba.v.forum_manager_center) {
            String str8 = "";
            djVar = this.a.s;
            if (djVar != null) {
                djVar2 = this.a.s;
                if (djVar2.b() != null) {
                    djVar3 = this.a.s;
                    str8 = djVar3.b().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str7 = this.a.e;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str7).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.v.recommend_forum_item_layout) {
            TiebaStatic.eventStat(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str9 = (String) view.getTag();
            str6 = this.a.e;
            if (str9.equals(str6)) {
                this.a.q = false;
                cqVar15 = this.a.n;
                if (cqVar15.n().isMenuShowing()) {
                    cqVar16 = this.a.n;
                    cqVar16.n().toggle(true);
                    return;
                }
                return;
            }
            this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this.a).a(str9, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
            this.a.a();
        }
    }
}
