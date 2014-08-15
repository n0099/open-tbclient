package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bw implements cq {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cq
    public void a(int i, JSONObject jSONObject, dp dpVar) {
        cr crVar;
        cr crVar2;
        dm dmVar;
        dm dmVar2;
        cr crVar3;
        int i2;
        int i3;
        dm dmVar3;
        int i4;
        dm dmVar4;
        dm dmVar5;
        dm dmVar6;
        dm dmVar7;
        cr crVar4;
        dm dmVar8;
        dm dmVar9;
        cr crVar5;
        String str;
        this.a.d();
        crVar = this.a.o;
        crVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (dpVar.a) {
                this.a.showToast(dpVar.d);
                if (dpVar.b && dpVar.c == 2000) {
                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                    str = this.a.f;
                    m252getInst.delFrsImageForum(str);
                }
            }
        } else {
            if (dpVar != null && dpVar.b) {
                i4 = this.a.n;
                if (i4 == 1) {
                    dmVar4 = this.a.t;
                    com.baidu.tieba.util.k.e(dmVar4.b().getName());
                }
            }
            crVar2 = this.a.o;
            crVar2.l().i();
            FrsImageActivity frsImageActivity = this.a;
            dmVar = this.a.t;
            frsImageActivity.a(dmVar.c());
            this.a.k = 30;
            dmVar2 = this.a.t;
            if (dmVar2.d().size() <= 30) {
                if (i == 1) {
                    dmVar3 = this.a.t;
                    if (dmVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            crVar3 = this.a.o;
            crVar3.l().scrollTo(0, 0);
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
        dmVar5 = this.a.t;
        m252getInst2.setDefaultBubble(dmVar5.a().b());
        TbadkApplication m252getInst3 = TbadkApplication.m252getInst();
        dmVar6 = this.a.t;
        m252getInst3.setDefaultBubbleEndTime(dmVar6.a().c());
        dmVar7 = this.a.t;
        if (dmVar7 != null) {
            dmVar8 = this.a.t;
            if (dmVar8.a() != null) {
                dmVar9 = this.a.t;
                if (dmVar9.a().a()) {
                    crVar5 = this.a.o;
                    crVar5.c(true);
                    return;
                }
            }
        }
        crVar4 = this.a.o;
        crVar4.c(false);
    }
}
