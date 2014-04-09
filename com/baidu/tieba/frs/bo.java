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
    public final void a(int i, JSONObject jSONObject, dd ddVar) {
        cj cjVar;
        cj cjVar2;
        da daVar;
        da daVar2;
        cj cjVar3;
        int i2;
        int i3;
        da daVar3;
        int i4;
        da daVar4;
        da daVar5;
        da daVar6;
        cj cjVar4;
        da daVar7;
        da daVar8;
        cj cjVar5;
        String str;
        FrsImageActivity.b(this.a);
        cjVar = this.a.l;
        cjVar.a(false);
        this.a.a();
        if (jSONObject == null) {
            if (ddVar.a) {
                this.a.showToast(ddVar.d);
                if (ddVar.b && ddVar.c == 2000) {
                    TbadkApplication j = TbadkApplication.j();
                    str = this.a.b;
                    j.o(str);
                }
            }
        } else {
            if (ddVar != null && ddVar.b) {
                i4 = this.a.k;
                if (i4 == 1) {
                    daVar4 = this.a.q;
                    com.baidu.tieba.util.k.f(daVar4.b().getName());
                }
            }
            cjVar2 = this.a.l;
            cjVar2.k().c();
            FrsImageActivity frsImageActivity = this.a;
            daVar = this.a.q;
            FrsImageActivity.a(frsImageActivity, daVar.c());
            this.a.h = 30;
            daVar2 = this.a.q;
            if (daVar2.d().size() <= 30) {
                if (i == 1) {
                    daVar3 = this.a.q;
                    if (daVar3.d().size() == 0) {
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
        daVar5 = this.a.q;
        j2.q(daVar5.a().b());
        daVar6 = this.a.q;
        if (daVar6 != null) {
            daVar7 = this.a.q;
            if (daVar7.a() != null) {
                daVar8 = this.a.q;
                if (daVar8.a().a()) {
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
