package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ai implements ax {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i) {
        boolean z;
        ay ayVar;
        z = this.a.s;
        if (!z) {
            ayVar = this.a.n;
            ayVar.a(true);
            return;
        }
        this.a.s = false;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.c.ab abVar) {
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.c.z zVar;
        com.baidu.tieba.c.z zVar2;
        ay ayVar3;
        int i2;
        int i3;
        com.baidu.tieba.c.z zVar3;
        int i4;
        com.baidu.tieba.c.z zVar4;
        String str;
        ayVar = this.a.n;
        ayVar.a(false);
        this.a.c("done");
        if (jSONObject == null) {
            if (abVar.a) {
                this.a.a(abVar.d);
                if (abVar.b && abVar.c == 2000) {
                    TiebaApplication e = TiebaApplication.e();
                    str = this.a.d;
                    e.d(str);
                    return;
                }
                return;
            }
            return;
        }
        if (abVar != null && abVar.b) {
            i4 = this.a.l;
            if (i4 == 1) {
                zVar4 = this.a.t;
                com.baidu.tieba.d.k.k(zVar4.a().b());
            }
        }
        ayVar2 = this.a.n;
        ayVar2.a().i();
        FrsImageActivity frsImageActivity = this.a;
        zVar = this.a.t;
        frsImageActivity.a(zVar.b());
        this.a.i = 30;
        zVar2 = this.a.t;
        if (zVar2.c().size() <= 30) {
            if (i == 1) {
                zVar3 = this.a.t;
                if (zVar3.c().size() == 0) {
                    this.a.a(aw.NO_ITEM);
                }
            }
            this.a.a(aw.LAST);
        } else {
            this.a.a(aw.NORMAL);
        }
        ayVar3 = this.a.n;
        ayVar3.a().scrollTo(0, 0);
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
