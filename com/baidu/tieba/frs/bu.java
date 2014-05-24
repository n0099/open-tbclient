package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bu implements cp {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cp
    public void a(int i, JSONObject jSONObject, dl dlVar) {
        cq cqVar;
        cq cqVar2;
        di diVar;
        di diVar2;
        cq cqVar3;
        int i2;
        int i3;
        di diVar3;
        int i4;
        di diVar4;
        di diVar5;
        di diVar6;
        cq cqVar4;
        di diVar7;
        di diVar8;
        cq cqVar5;
        String str;
        this.a.d();
        cqVar = this.a.o;
        cqVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (dlVar.a) {
                this.a.showToast(dlVar.d);
                if (dlVar.b && dlVar.c == 2000) {
                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                    str = this.a.e;
                    m252getInst.delFrsImageForum(str);
                }
            }
        } else {
            if (dlVar != null && dlVar.b) {
                i4 = this.a.n;
                if (i4 == 1) {
                    diVar4 = this.a.t;
                    com.baidu.tieba.util.k.f(diVar4.b().getName());
                }
            }
            cqVar2 = this.a.o;
            cqVar2.l().i();
            FrsImageActivity frsImageActivity = this.a;
            diVar = this.a.t;
            frsImageActivity.a(diVar.c());
            this.a.k = 30;
            diVar2 = this.a.t;
            if (diVar2.d().size() <= 30) {
                if (i == 1) {
                    diVar3 = this.a.t;
                    if (diVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            cqVar3 = this.a.o;
            cqVar3.l().scrollTo(0, 0);
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
        diVar5 = this.a.t;
        m252getInst2.setDefaultBubble(diVar5.a().b());
        diVar6 = this.a.t;
        if (diVar6 != null) {
            diVar7 = this.a.t;
            if (diVar7.a() != null) {
                diVar8 = this.a.t;
                if (diVar8.a().a()) {
                    cqVar5 = this.a.o;
                    cqVar5.c(true);
                    return;
                }
            }
        }
        cqVar4 = this.a.o;
        cqVar4.c(false);
    }
}
