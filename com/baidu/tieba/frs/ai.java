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
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.c.y yVar) {
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.c.w wVar;
        com.baidu.tieba.c.w wVar2;
        ay ayVar3;
        int i2;
        int i3;
        com.baidu.tieba.c.w wVar3;
        int i4;
        com.baidu.tieba.c.w wVar4;
        String str;
        ayVar = this.a.n;
        ayVar.a(false);
        this.a.c("done");
        if (jSONObject == null) {
            if (yVar.a) {
                this.a.a(yVar.d);
                if (yVar.b && yVar.c == 2000) {
                    TiebaApplication d = TiebaApplication.d();
                    str = this.a.d;
                    d.d(str);
                    return;
                }
                return;
            }
            return;
        }
        if (yVar != null && yVar.b) {
            i4 = this.a.l;
            if (i4 == 1) {
                wVar4 = this.a.t;
                com.baidu.tieba.d.k.k(wVar4.a().b());
            }
        }
        ayVar2 = this.a.n;
        ayVar2.a().i();
        FrsImageActivity frsImageActivity = this.a;
        wVar = this.a.t;
        frsImageActivity.a(wVar.b());
        this.a.i = 30;
        wVar2 = this.a.t;
        if (wVar2.c().size() <= 30) {
            if (i == 1) {
                wVar3 = this.a.t;
                if (wVar3.c().size() == 0) {
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
