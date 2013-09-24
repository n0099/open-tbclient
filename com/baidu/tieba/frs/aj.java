package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class aj implements ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1120a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsImageActivity frsImageActivity) {
        this.f1120a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i) {
        boolean z;
        ay ayVar;
        z = this.f1120a.r;
        if (!z) {
            ayVar = this.f1120a.m;
            ayVar.a(true);
            return;
        }
        this.f1120a.r = false;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ao aoVar) {
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.model.am amVar;
        com.baidu.tieba.model.am amVar2;
        ay ayVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.am amVar3;
        int i4;
        com.baidu.tieba.model.am amVar4;
        String str;
        this.f1120a.c();
        ayVar = this.f1120a.m;
        ayVar.a(false);
        this.f1120a.c("done");
        if (jSONObject == null) {
            if (aoVar.f1401a) {
                this.f1120a.a(aoVar.d);
                if (aoVar.b && aoVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.f1120a.b;
                    g.i(str);
                    return;
                }
                return;
            }
            return;
        }
        if (aoVar != null && aoVar.b) {
            i4 = this.f1120a.l;
            if (i4 == 1) {
                amVar4 = this.f1120a.s;
                DatabaseService.l(amVar4.a().b());
            }
        }
        ayVar2 = this.f1120a.m;
        ayVar2.a().i();
        FrsImageActivity frsImageActivity = this.f1120a;
        amVar = this.f1120a.s;
        frsImageActivity.a(amVar.b());
        this.f1120a.g = 30;
        amVar2 = this.f1120a.s;
        if (amVar2.c().size() <= 30) {
            if (i == 1) {
                amVar3 = this.f1120a.s;
                if (amVar3.c().size() == 0) {
                    this.f1120a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1120a.a(FrsImageActivity.FooterType.LAST);
        } else {
            this.f1120a.a(FrsImageActivity.FooterType.NORMAL);
        }
        ayVar3 = this.f1120a.m;
        ayVar3.a().scrollTo(0, 0);
        this.f1120a.j = i;
        i2 = this.f1120a.j;
        if (i2 > 1) {
            this.f1120a.n();
        } else {
            this.f1120a.o();
        }
        i3 = this.f1120a.l;
        if (i3 == 1) {
            this.f1120a.l = 0;
            this.f1120a.getIntent().putExtra("add_search", 0);
        }
    }
}
