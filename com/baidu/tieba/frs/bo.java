package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class bo implements ci {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ci
    public final void a(int i, JSONObject jSONObject, db dbVar) {
        cj cjVar;
        cj cjVar2;
        cy cyVar;
        cy cyVar2;
        cj cjVar3;
        int i2;
        int i3;
        cy cyVar3;
        int i4;
        cy cyVar4;
        cy cyVar5;
        cy cyVar6;
        cj cjVar4;
        cy cyVar7;
        cy cyVar8;
        cj cjVar5;
        String str;
        FrsImageActivity.b(this.a);
        cjVar = this.a.l;
        cjVar.a(false);
        this.a.a();
        if (jSONObject == null) {
            if (dbVar.a) {
                this.a.showToast(dbVar.d);
                if (dbVar.b && dbVar.c == 2000) {
                    TbadkApplication j = TbadkApplication.j();
                    str = this.a.b;
                    j.o(str);
                }
            }
        } else {
            if (dbVar != null && dbVar.b) {
                i4 = this.a.k;
                if (i4 == 1) {
                    cyVar4 = this.a.q;
                    com.baidu.tieba.util.k.f(cyVar4.b().getName());
                }
            }
            cjVar2 = this.a.l;
            cjVar2.k().c();
            FrsImageActivity frsImageActivity = this.a;
            cyVar = this.a.q;
            FrsImageActivity.a(frsImageActivity, cyVar.c());
            this.a.h = 30;
            cyVar2 = this.a.q;
            if (cyVar2.d().size() <= 30) {
                if (i == 1) {
                    cyVar3 = this.a.q;
                    if (cyVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            cjVar3 = this.a.l;
            cjVar3.k().scrollTo(0, 0);
            this.a.i = i;
            i2 = this.a.i;
            if (i2 > 1) {
                FrsImageActivity.g(this.a);
            } else {
                this.a.l.k().b();
            }
            i3 = this.a.k;
            if (i3 == 1) {
                this.a.k = 0;
                this.a.getIntent().putExtra("add_search", 0);
            }
        }
        TbadkApplication j2 = TbadkApplication.j();
        cyVar5 = this.a.q;
        j2.q(cyVar5.a().b());
        cyVar6 = this.a.q;
        if (cyVar6 != null) {
            cyVar7 = this.a.q;
            if (cyVar7.a() != null) {
                cyVar8 = this.a.q;
                if (cyVar8.a().a()) {
                    cjVar5 = this.a.l;
                    cjVar5.c(true);
                    return;
                }
            }
        }
        cjVar4 = this.a.l;
        cjVar4.c(false);
    }
}
