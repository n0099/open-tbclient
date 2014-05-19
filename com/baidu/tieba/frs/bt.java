package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bt implements co {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.co
    public void a(int i, JSONObject jSONObject, dk dkVar) {
        cp cpVar;
        cp cpVar2;
        dh dhVar;
        dh dhVar2;
        cp cpVar3;
        int i2;
        int i3;
        dh dhVar3;
        int i4;
        dh dhVar4;
        dh dhVar5;
        dh dhVar6;
        cp cpVar4;
        dh dhVar7;
        dh dhVar8;
        cp cpVar5;
        String str;
        this.a.d();
        cpVar = this.a.o;
        cpVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (dkVar.a) {
                this.a.showToast(dkVar.d);
                if (dkVar.b && dkVar.c == 2000) {
                    TbadkApplication m252getInst = TbadkApplication.m252getInst();
                    str = this.a.e;
                    m252getInst.delFrsImageForum(str);
                }
            }
        } else {
            if (dkVar != null && dkVar.b) {
                i4 = this.a.n;
                if (i4 == 1) {
                    dhVar4 = this.a.t;
                    com.baidu.tieba.util.k.f(dhVar4.b().getName());
                }
            }
            cpVar2 = this.a.o;
            cpVar2.l().i();
            FrsImageActivity frsImageActivity = this.a;
            dhVar = this.a.t;
            frsImageActivity.a(dhVar.c());
            this.a.k = 30;
            dhVar2 = this.a.t;
            if (dhVar2.d().size() <= 30) {
                if (i == 1) {
                    dhVar3 = this.a.t;
                    if (dhVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            cpVar3 = this.a.o;
            cpVar3.l().scrollTo(0, 0);
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
        dhVar5 = this.a.t;
        m252getInst2.setDefaultBubble(dhVar5.a().b());
        dhVar6 = this.a.t;
        if (dhVar6 != null) {
            dhVar7 = this.a.t;
            if (dhVar7.a() != null) {
                dhVar8 = this.a.t;
                if (dhVar8.a().a()) {
                    cpVar5 = this.a.o;
                    cpVar5.c(true);
                    return;
                }
            }
        }
        cpVar4 = this.a.o;
        cpVar4.c(false);
    }
}
