package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ai implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsImageActivity frsImageActivity) {
        this.f1059a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        boolean z;
        ax axVar;
        z = this.f1059a.s;
        if (!z) {
            axVar = this.f1059a.n;
            axVar.a(true);
            return;
        }
        this.f1059a.s = false;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.am amVar) {
        ax axVar;
        ax axVar2;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        ax axVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.ak akVar3;
        int i4;
        com.baidu.tieba.model.ak akVar4;
        String str;
        axVar = this.f1059a.n;
        axVar.a(false);
        this.f1059a.c("done");
        if (jSONObject == null) {
            if (amVar.f1331a) {
                this.f1059a.a(amVar.d);
                if (amVar.b && amVar.c == 2000) {
                    TiebaApplication f = TiebaApplication.f();
                    str = this.f1059a.b;
                    f.f(str);
                    return;
                }
                return;
            }
            return;
        }
        if (amVar != null && amVar.b) {
            i4 = this.f1059a.l;
            if (i4 == 1) {
                akVar4 = this.f1059a.t;
                DatabaseService.n(akVar4.a().b());
            }
        }
        axVar2 = this.f1059a.n;
        axVar2.a().i();
        FrsImageActivity frsImageActivity = this.f1059a;
        akVar = this.f1059a.t;
        frsImageActivity.a(akVar.b());
        this.f1059a.g = 30;
        akVar2 = this.f1059a.t;
        if (akVar2.c().size() <= 30) {
            if (i == 1) {
                akVar3 = this.f1059a.t;
                if (akVar3.c().size() == 0) {
                    this.f1059a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1059a.a(FrsImageActivity.FooterType.LAST);
        } else {
            this.f1059a.a(FrsImageActivity.FooterType.NORMAL);
        }
        axVar3 = this.f1059a.n;
        axVar3.a().scrollTo(0, 0);
        this.f1059a.j = i;
        i2 = this.f1059a.j;
        if (i2 > 1) {
            this.f1059a.l();
        } else {
            this.f1059a.m();
        }
        i3 = this.f1059a.l;
        if (i3 == 1) {
            this.f1059a.l = 0;
            this.f1059a.getIntent().putExtra("add_search", 0);
        }
    }
}
