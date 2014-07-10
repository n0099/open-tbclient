package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bv implements cp {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cp
    public void a(int i, JSONObject jSONObject, dm dmVar) {
        cq cqVar;
        cq cqVar2;
        dj djVar;
        dj djVar2;
        cq cqVar3;
        int i2;
        int i3;
        dj djVar3;
        int i4;
        dj djVar4;
        dj djVar5;
        dj djVar6;
        dj djVar7;
        cq cqVar4;
        dj djVar8;
        dj djVar9;
        cq cqVar5;
        String str;
        this.a.d();
        cqVar = this.a.n;
        cqVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (dmVar.a) {
                this.a.showToast(dmVar.d);
                if (dmVar.b && dmVar.c == 2000) {
                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                    str = this.a.e;
                    m252getInst.delFrsImageForum(str);
                }
            }
        } else {
            if (dmVar != null && dmVar.b) {
                i4 = this.a.m;
                if (i4 == 1) {
                    djVar4 = this.a.s;
                    com.baidu.tieba.util.k.f(djVar4.b().getName());
                }
            }
            cqVar2 = this.a.n;
            cqVar2.l().i();
            FrsImageActivity frsImageActivity = this.a;
            djVar = this.a.s;
            frsImageActivity.a(djVar.c());
            this.a.j = 30;
            djVar2 = this.a.s;
            if (djVar2.d().size() <= 30) {
                if (i == 1) {
                    djVar3 = this.a.s;
                    if (djVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            cqVar3 = this.a.n;
            cqVar3.l().scrollTo(0, 0);
            this.a.k = i;
            i2 = this.a.k;
            if (i2 > 1) {
                this.a.i();
            } else {
                this.a.j();
            }
            i3 = this.a.m;
            if (i3 == 1) {
                this.a.m = 0;
                this.a.getIntent().putExtra("add_search", 0);
            }
        }
        TbadkApplication m252getInst2 = TbadkApplication.m252getInst();
        djVar5 = this.a.s;
        m252getInst2.setDefaultBubble(djVar5.a().b());
        TbadkApplication m252getInst3 = TbadkApplication.m252getInst();
        djVar6 = this.a.s;
        m252getInst3.setDefaultBubbleEndTime(djVar6.a().c());
        djVar7 = this.a.s;
        if (djVar7 != null) {
            djVar8 = this.a.s;
            if (djVar8.a() != null) {
                djVar9 = this.a.s;
                if (djVar9.a().a()) {
                    cqVar5 = this.a.n;
                    cqVar5.c(true);
                    return;
                }
            }
        }
        cqVar4 = this.a.n;
        cqVar4.c(false);
    }
}
