package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ai implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsImageActivity frsImageActivity) {
        this.f1057a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        boolean z;
        ax axVar;
        z = this.f1057a.s;
        if (!z) {
            axVar = this.f1057a.n;
            axVar.a(true);
            return;
        }
        this.f1057a.s = false;
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
        axVar = this.f1057a.n;
        axVar.a(false);
        this.f1057a.c("done");
        if (jSONObject == null) {
            if (amVar.f1329a) {
                this.f1057a.a(amVar.d);
                if (amVar.b && amVar.c == 2000) {
                    TiebaApplication f = TiebaApplication.f();
                    str = this.f1057a.b;
                    f.f(str);
                    return;
                }
                return;
            }
            return;
        }
        if (amVar != null && amVar.b) {
            i4 = this.f1057a.l;
            if (i4 == 1) {
                akVar4 = this.f1057a.t;
                DatabaseService.n(akVar4.a().b());
            }
        }
        axVar2 = this.f1057a.n;
        axVar2.a().i();
        FrsImageActivity frsImageActivity = this.f1057a;
        akVar = this.f1057a.t;
        frsImageActivity.a(akVar.b());
        this.f1057a.g = 30;
        akVar2 = this.f1057a.t;
        if (akVar2.c().size() <= 30) {
            if (i == 1) {
                akVar3 = this.f1057a.t;
                if (akVar3.c().size() == 0) {
                    this.f1057a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1057a.a(FrsImageActivity.FooterType.LAST);
        } else {
            this.f1057a.a(FrsImageActivity.FooterType.NORMAL);
        }
        axVar3 = this.f1057a.n;
        axVar3.a().scrollTo(0, 0);
        this.f1057a.j = i;
        i2 = this.f1057a.j;
        if (i2 > 1) {
            this.f1057a.l();
        } else {
            this.f1057a.m();
        }
        i3 = this.f1057a.l;
        if (i3 == 1) {
            this.f1057a.l = 0;
            this.f1057a.getIntent().putExtra("add_search", 0);
        }
    }
}
