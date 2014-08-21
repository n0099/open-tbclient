package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bx implements cr {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cr
    public void a(int i, JSONObject jSONObject, dr drVar) {
        cs csVar;
        cs csVar2;
        Cdo cdo;
        Cdo cdo2;
        cs csVar3;
        int i2;
        int i3;
        Cdo cdo3;
        int i4;
        Cdo cdo4;
        Cdo cdo5;
        Cdo cdo6;
        Cdo cdo7;
        cs csVar4;
        Cdo cdo8;
        Cdo cdo9;
        cs csVar5;
        String str;
        this.a.d();
        csVar = this.a.o;
        csVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (drVar.a) {
                this.a.showToast(drVar.d);
                if (drVar.b && drVar.c == 2000) {
                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                    str = this.a.f;
                    m252getInst.delFrsImageForum(str);
                }
            }
        } else {
            if (drVar != null && drVar.b) {
                i4 = this.a.n;
                if (i4 == 1) {
                    cdo4 = this.a.t;
                    com.baidu.tieba.util.k.e(cdo4.b().getName());
                }
            }
            csVar2 = this.a.o;
            csVar2.l().i();
            FrsImageActivity frsImageActivity = this.a;
            cdo = this.a.t;
            frsImageActivity.a(cdo.c());
            this.a.k = 30;
            cdo2 = this.a.t;
            if (cdo2.d().size() <= 30) {
                if (i == 1) {
                    cdo3 = this.a.t;
                    if (cdo3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            csVar3 = this.a.o;
            csVar3.l().scrollTo(0, 0);
            this.a.l = i;
            i2 = this.a.l;
            if (i2 > 1) {
                this.a.i();
            } else {
                this.a.j();
            }
            i3 = this.a.n;
            if (i3 == 1) {
                this.a.n = 0;
                this.a.getIntent().putExtra("add_search", 0);
            }
        }
        TbadkApplication m252getInst2 = TbadkApplication.m252getInst();
        cdo5 = this.a.t;
        m252getInst2.setDefaultBubble(cdo5.a().b());
        TbadkApplication m252getInst3 = TbadkApplication.m252getInst();
        cdo6 = this.a.t;
        m252getInst3.setDefaultBubbleEndTime(cdo6.a().c());
        cdo7 = this.a.t;
        if (cdo7 != null) {
            cdo8 = this.a.t;
            if (cdo8.a() != null) {
                cdo9 = this.a.t;
                if (cdo9.a().a()) {
                    csVar5 = this.a.o;
                    csVar5.c(true);
                    return;
                }
            }
        }
        csVar4 = this.a.o;
        csVar4.c(false);
    }
}
