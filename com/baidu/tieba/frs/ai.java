package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ai implements aw {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        boolean z;
        ax axVar;
        z = this.a.s;
        if (!z) {
            axVar = this.a.n;
            axVar.a(true);
            return;
        }
        this.a.s = false;
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
        axVar = this.a.n;
        axVar.a(false);
        this.a.c("done");
        if (jSONObject == null) {
            if (aeVar.a) {
                this.a.a(aeVar.d);
                if (aeVar.b && aeVar.c == 2000) {
                    TiebaApplication f = TiebaApplication.f();
                    str = this.a.b;
                    f.f(str);
                    return;
                }
                return;
            }
            return;
        }
        if (aeVar != null && aeVar.b) {
            i4 = this.a.l;
            if (i4 == 1) {
                acVar4 = this.a.t;
                DatabaseService.n(acVar4.a().b());
            }
        }
        axVar2 = this.a.n;
        axVar2.a().i();
        FrsImageActivity frsImageActivity = this.a;
        acVar = this.a.t;
        frsImageActivity.a(acVar.b());
        this.a.g = 30;
        acVar2 = this.a.t;
        if (acVar2.c().size() <= 30) {
            if (i == 1) {
                acVar3 = this.a.t;
                if (acVar3.c().size() == 0) {
                    this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.a.a(FrsImageActivity.FooterType.LAST);
        } else {
            this.a.a(FrsImageActivity.FooterType.NORMAL);
        }
        axVar3 = this.a.n;
        axVar3.a().scrollTo(0, 0);
        this.a.j = i;
        i2 = this.a.j;
        if (i2 > 1) {
            this.a.n();
        } else {
            this.a.o();
        }
        i3 = this.a.l;
        if (i3 == 1) {
            this.a.l = 0;
            this.a.getIntent().putExtra("add_search", 0);
        }
    }
}
