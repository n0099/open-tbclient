package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class as implements bk {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        boolean z;
        bl blVar;
        z = this.a.q;
        if (z) {
            this.a.q = false;
            return;
        }
        blVar = this.a.l;
        blVar.a(true);
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        bl blVar;
        bl blVar2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        bl blVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.ar arVar3;
        int i4;
        com.baidu.tieba.model.ar arVar4;
        String str;
        this.a.d();
        blVar = this.a.l;
        blVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (atVar.a) {
                this.a.showToast(atVar.d);
                if (atVar.b && atVar.c == 2000) {
                    TiebaApplication h = TiebaApplication.h();
                    str = this.a.b;
                    h.j(str);
                    return;
                }
                return;
            }
            return;
        }
        if (atVar != null && atVar.b) {
            i4 = this.a.k;
            if (i4 == 1) {
                arVar4 = this.a.r;
                DatabaseService.m(arVar4.a().getName());
            }
        }
        blVar2 = this.a.l;
        blVar2.e().g();
        FrsImageActivity frsImageActivity = this.a;
        arVar = this.a.r;
        frsImageActivity.a(arVar.b());
        this.a.h = 30;
        arVar2 = this.a.r;
        if (arVar2.c().size() > 30) {
            this.a.a(FrsImageActivity.FooterType.NORMAL);
        } else {
            if (i == 1) {
                arVar3 = this.a.r;
                if (arVar3.c().size() == 0) {
                    this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.a.a(FrsImageActivity.FooterType.LAST);
        }
        blVar3 = this.a.l;
        blVar3.e().scrollTo(0, 0);
        this.a.i = i;
        i2 = this.a.i;
        if (i2 > 1) {
            this.a.h();
        } else {
            this.a.i();
        }
        i3 = this.a.k;
        if (i3 == 1) {
            this.a.k = 0;
            this.a.getIntent().putExtra("add_search", 0);
        }
    }
}
