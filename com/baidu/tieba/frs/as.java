package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class as implements bk {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsImageActivity frsImageActivity) {
        this.f1318a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        boolean z;
        bl blVar;
        z = this.f1318a.q;
        if (z) {
            this.f1318a.q = false;
            return;
        }
        blVar = this.f1318a.l;
        blVar.a(true);
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        bl blVar;
        bl blVar2;
        com.baidu.tieba.model.ar arVar;
        bl blVar3;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bl blVar4;
        int i2;
        int i3;
        com.baidu.tieba.model.ar arVar4;
        int i4;
        com.baidu.tieba.model.ar arVar5;
        String str;
        this.f1318a.d();
        blVar = this.f1318a.l;
        blVar.a(false);
        this.f1318a.a("done");
        if (jSONObject == null) {
            if (atVar.f1900a) {
                this.f1318a.showToast(atVar.d);
                if (atVar.b && atVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.f1318a.b;
                    g.i(str);
                    return;
                }
                return;
            }
            return;
        }
        if (atVar != null && atVar.b) {
            i4 = this.f1318a.k;
            if (i4 == 1) {
                arVar5 = this.f1318a.r;
                DatabaseService.m(arVar5.a().getName());
            }
        }
        blVar2 = this.f1318a.l;
        blVar2.e().g();
        FrsImageActivity frsImageActivity = this.f1318a;
        arVar = this.f1318a.r;
        frsImageActivity.a(arVar.b());
        blVar3 = this.f1318a.l;
        bs f = blVar3.f();
        arVar2 = this.f1318a.r;
        f.c(arVar2.a().isLike() != 0);
        this.f1318a.h = 30;
        arVar3 = this.f1318a.r;
        if (arVar3.c().size() > 30) {
            this.f1318a.a(FrsImageActivity.FooterType.NORMAL);
        } else {
            if (i == 1) {
                arVar4 = this.f1318a.r;
                if (arVar4.c().size() == 0) {
                    this.f1318a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1318a.a(FrsImageActivity.FooterType.LAST);
        }
        blVar4 = this.f1318a.l;
        blVar4.e().scrollTo(0, 0);
        this.f1318a.i = i;
        i2 = this.f1318a.i;
        if (i2 > 1) {
            this.f1318a.h();
        } else {
            this.f1318a.i();
        }
        i3 = this.f1318a.k;
        if (i3 == 1) {
            this.f1318a.k = 0;
            this.f1318a.getIntent().putExtra("add_search", 0);
        }
    }
}
