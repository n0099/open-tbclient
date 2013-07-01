package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ai implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsImageActivity frsImageActivity) {
        this.f835a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        boolean z;
        ax axVar;
        z = this.f835a.s;
        if (!z) {
            axVar = this.f835a.n;
            axVar.a(true);
            return;
        }
        this.f835a.s = false;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ae aeVar) {
        ax axVar;
        ax axVar2;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        ax axVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.ac acVar3;
        int i4;
        com.baidu.tieba.model.ac acVar4;
        String str;
        axVar = this.f835a.n;
        axVar.a(false);
        this.f835a.c("done");
        if (jSONObject == null) {
            if (aeVar.f1011a) {
                this.f835a.a(aeVar.d);
                if (aeVar.b && aeVar.c == 2000) {
                    TiebaApplication f = TiebaApplication.f();
                    str = this.f835a.b;
                    f.f(str);
                    return;
                }
                return;
            }
            return;
        }
        if (aeVar != null && aeVar.b) {
            i4 = this.f835a.l;
            if (i4 == 1) {
                acVar4 = this.f835a.t;
                DatabaseService.n(acVar4.a().b());
            }
        }
        axVar2 = this.f835a.n;
        axVar2.a().i();
        FrsImageActivity frsImageActivity = this.f835a;
        acVar = this.f835a.t;
        frsImageActivity.a(acVar.b());
        this.f835a.g = 30;
        acVar2 = this.f835a.t;
        if (acVar2.c().size() <= 30) {
            if (i == 1) {
                acVar3 = this.f835a.t;
                if (acVar3.c().size() == 0) {
                    this.f835a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f835a.a(FrsImageActivity.FooterType.LAST);
        } else {
            this.f835a.a(FrsImageActivity.FooterType.NORMAL);
        }
        axVar3 = this.f835a.n;
        axVar3.a().scrollTo(0, 0);
        this.f835a.j = i;
        i2 = this.f835a.j;
        if (i2 > 1) {
            this.f835a.n();
        } else {
            this.f835a.o();
        }
        i3 = this.f835a.l;
        if (i3 == 1) {
            this.f835a.l = 0;
            this.f835a.getIntent().putExtra("add_search", 0);
        }
    }
}
