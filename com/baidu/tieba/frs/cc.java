package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
final class cc implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cj cjVar4;
        cj cjVar5;
        cj cjVar6;
        cj cjVar7;
        cj cjVar8;
        cj cjVar9;
        String str;
        cj cjVar10;
        cj cjVar11;
        String str2;
        String str3;
        cj cjVar12;
        String str4;
        String str5;
        cj cjVar13;
        String str6;
        cj cjVar14;
        cj cjVar15;
        da daVar;
        String str7;
        da daVar2;
        da daVar3;
        cjVar = this.a.l;
        if (view != cjVar.e()) {
            cjVar2 = this.a.l;
            if (view != cjVar2.c()) {
                cjVar3 = this.a.l;
                if (view == cjVar3.d()) {
                    this.a.closeActivity();
                } else {
                    cjVar4 = this.a.l;
                    if (view != cjVar4.f()) {
                        cjVar5 = this.a.l;
                        if (view == cjVar5.g()) {
                            cjVar12 = this.a.l;
                            cjVar12.b();
                            this.a.o = false;
                            TbadkApplication j = TbadkApplication.j();
                            str4 = this.a.b;
                            j.o(str4);
                            FrsImageActivity frsImageActivity = this.a;
                            com.baidu.tbadk.core.b.l lVar = new com.baidu.tbadk.core.b.l(this.a);
                            str5 = this.a.b;
                            frsImageActivity.sendMessage(new com.baidu.adp.framework.message.a(2003000, lVar.a(str5, null)));
                            this.a.b();
                        } else {
                            cjVar6 = this.a.l;
                            if (view == cjVar6.h()) {
                                cjVar11 = this.a.l;
                                cjVar11.b();
                                this.a.o = false;
                                TiebaStatic.a(this.a, "frs_good", "frsclick", 1, new Object[0]);
                                TbadkApplication j2 = TbadkApplication.j();
                                str2 = this.a.b;
                                j2.o(str2);
                                FrsImageActivity frsImageActivity2 = this.a;
                                com.baidu.tbadk.core.b.l lVar2 = new com.baidu.tbadk.core.b.l(this.a);
                                str3 = this.a.b;
                                frsImageActivity2.sendMessage(new com.baidu.adp.framework.message.a(2003000, lVar2.b(str3, null)));
                                this.a.b();
                            } else {
                                cjVar7 = this.a.l;
                                if (view == cjVar7.i()) {
                                    cjVar10 = this.a.l;
                                    cjVar10.b();
                                } else {
                                    cjVar8 = this.a.l;
                                    if (view == cjVar8.j()) {
                                        cjVar9 = this.a.l;
                                        cjVar9.b();
                                        FrsImageActivity frsImageActivity3 = this.a;
                                        str = this.a.b;
                                        FrsImageActivity.a(frsImageActivity3, str);
                                    }
                                }
                            }
                        }
                    } else {
                        TiebaStatic.a(this.a, "frs_more", "frsclick", 1, new Object[0]);
                        cjVar13 = this.a.l;
                        cjVar13.b(true);
                    }
                }
            } else {
                this.a.l.a();
            }
        } else {
            this.a.a(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.a.h.message_layout) {
            String E = TbadkApplication.E();
            if (E != null && E.length() > 0) {
                TiebaStatic.a(this.a, "frs_message", "frsclick", 1, new Object[0]);
                this.a.sendMessage(new com.baidu.adp.framework.message.a(2015003, new com.baidu.tbadk.core.frameworkData.a(this.a)));
            }
        } else if (id == com.baidu.tieba.a.h.forum_manager_center) {
            String str8 = "";
            daVar = this.a.q;
            if (daVar != null) {
                daVar2 = this.a.q;
                if (daVar2.b() != null) {
                    daVar3 = this.a.q;
                    str8 = daVar3.b().getId();
                }
            }
            StringBuilder sb = new StringBuilder("http://tieba.baidu.com/mo/q/bawuindex?fn=");
            str7 = this.a.b;
            com.baidu.tbadk.browser.a.a(this.a, sb.append(str7).append("&fid=").append(str8).toString());
        } else if (id == com.baidu.tieba.a.h.recommend_forum_item_layout) {
            TiebaStatic.a(this.a, "frs_likeforum", "frsclick", 1, new Object[0]);
            String str9 = (String) view.getTag();
            str6 = this.a.b;
            if (str9.equals(str6)) {
                this.a.o = false;
                cjVar14 = this.a.l;
                if (cjVar14.m().isMenuShowing()) {
                    cjVar15 = this.a.l;
                    cjVar15.m().toggle(true);
                    return;
                }
                return;
            }
            this.a.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.a).a(str9, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
            this.a.b();
        }
    }
}
