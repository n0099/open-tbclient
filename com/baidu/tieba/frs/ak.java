package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ak implements ay {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsImageActivity frsImageActivity) {
        this.f1073a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ay
    public void a(int i) {
        boolean z;
        az azVar;
        z = this.f1073a.s;
        if (!z) {
            azVar = this.f1073a.n;
            azVar.a(true);
            return;
        }
        this.f1073a.s = false;
    }

    @Override // com.baidu.tieba.frs.ay
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.am amVar) {
        az azVar;
        az azVar2;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        az azVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.ak akVar3;
        int i4;
        com.baidu.tieba.model.ak akVar4;
        String str;
        this.f1073a.c();
        azVar = this.f1073a.n;
        azVar.a(false);
        this.f1073a.c("done");
        if (jSONObject == null) {
            if (amVar.f1364a) {
                this.f1073a.a(amVar.d);
                if (amVar.b && amVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.f1073a.b;
                    g.i(str);
                    return;
                }
                return;
            }
            return;
        }
        if (amVar != null && amVar.b) {
            i4 = this.f1073a.l;
            if (i4 == 1) {
                akVar4 = this.f1073a.t;
                DatabaseService.l(akVar4.a().b());
            }
        }
        azVar2 = this.f1073a.n;
        azVar2.a().i();
        FrsImageActivity frsImageActivity = this.f1073a;
        akVar = this.f1073a.t;
        frsImageActivity.a(akVar.b());
        this.f1073a.g = 30;
        akVar2 = this.f1073a.t;
        if (akVar2.c().size() <= 30) {
            if (i == 1) {
                akVar3 = this.f1073a.t;
                if (akVar3.c().size() == 0) {
                    this.f1073a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1073a.a(FrsImageActivity.FooterType.LAST);
        } else {
            this.f1073a.a(FrsImageActivity.FooterType.NORMAL);
        }
        azVar3 = this.f1073a.n;
        azVar3.a().scrollTo(0, 0);
        this.f1073a.j = i;
        i2 = this.f1073a.j;
        if (i2 > 1) {
            this.f1073a.m();
        } else {
            this.f1073a.n();
        }
        i3 = this.f1073a.l;
        if (i3 == 1) {
            this.f1073a.l = 0;
            this.f1073a.getIntent().putExtra("add_search", 0);
        }
    }
}
