package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements bk {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        boolean z;
        bm bmVar;
        z = this.a.p;
        if (z) {
            this.a.p = false;
            return;
        }
        bmVar = this.a.l;
        bmVar.a(true);
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        bm bmVar;
        bm bmVar2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        bm bmVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.ar arVar3;
        int i4;
        com.baidu.tieba.model.ar arVar4;
        String str;
        this.a.d();
        bmVar = this.a.l;
        bmVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (atVar.a) {
                this.a.showToast(atVar.d);
                if (atVar.b && atVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.a.b;
                    g.j(str);
                    return;
                }
                return;
            }
            return;
        }
        if (atVar != null && atVar.b) {
            i4 = this.a.k;
            if (i4 == 1) {
                arVar4 = this.a.q;
                DatabaseService.m(arVar4.a().getName());
            }
        }
        bmVar2 = this.a.l;
        bmVar2.e().g();
        FrsImageActivity frsImageActivity = this.a;
        arVar = this.a.q;
        frsImageActivity.a(arVar.b());
        this.a.h = 30;
        arVar2 = this.a.q;
        if (arVar2.c().size() > 30) {
            this.a.a(FrsImageActivity.FooterType.NORMAL);
        } else {
            if (i == 1) {
                arVar3 = this.a.q;
                if (arVar3.c().size() == 0) {
                    this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.a.a(FrsImageActivity.FooterType.LAST);
        }
        bmVar3 = this.a.l;
        bmVar3.e().scrollTo(0, 0);
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
