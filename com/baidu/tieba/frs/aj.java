package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class aj implements ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1253a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsImageActivity frsImageActivity) {
        this.f1253a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i) {
        boolean z;
        ay ayVar;
        z = this.f1253a.r;
        if (z) {
            this.f1253a.r = false;
            return;
        }
        ayVar = this.f1253a.m;
        ayVar.a(true);
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.aw awVar) {
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.model.au auVar;
        com.baidu.tieba.model.au auVar2;
        ay ayVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.au auVar3;
        int i4;
        com.baidu.tieba.model.au auVar4;
        String str;
        this.f1253a.c();
        ayVar = this.f1253a.m;
        ayVar.a(false);
        this.f1253a.c("done");
        if (jSONObject == null) {
            if (awVar.f1906a) {
                this.f1253a.a(awVar.d);
                if (awVar.b && awVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.f1253a.b;
                    g.i(str);
                    return;
                }
                return;
            }
            return;
        }
        if (awVar != null && awVar.b) {
            i4 = this.f1253a.l;
            if (i4 == 1) {
                auVar4 = this.f1253a.s;
                DatabaseService.l(auVar4.a().getName());
            }
        }
        ayVar2 = this.f1253a.m;
        ayVar2.a().g();
        FrsImageActivity frsImageActivity = this.f1253a;
        auVar = this.f1253a.s;
        frsImageActivity.a(auVar.b());
        this.f1253a.g = 30;
        auVar2 = this.f1253a.s;
        if (auVar2.c().size() > 30) {
            this.f1253a.a(FrsImageActivity.FooterType.NORMAL);
        } else {
            if (i == 1) {
                auVar3 = this.f1253a.s;
                if (auVar3.c().size() == 0) {
                    this.f1253a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1253a.a(FrsImageActivity.FooterType.LAST);
        }
        ayVar3 = this.f1253a.m;
        ayVar3.a().scrollTo(0, 0);
        this.f1253a.j = i;
        i2 = this.f1253a.j;
        if (i2 > 1) {
            this.f1253a.n();
        } else {
            this.f1253a.o();
        }
        i3 = this.f1253a.l;
        if (i3 == 1) {
            this.f1253a.l = 0;
            this.f1253a.getIntent().putExtra("add_search", 0);
        }
    }
}
