package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class as implements bk {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsImageActivity frsImageActivity) {
        this.f1323a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        boolean z;
        bl blVar;
        z = this.f1323a.q;
        if (z) {
            this.f1323a.q = false;
            return;
        }
        blVar = this.f1323a.l;
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
        this.f1323a.d();
        blVar = this.f1323a.l;
        blVar.a(false);
        this.f1323a.a("done");
        if (jSONObject == null) {
            if (atVar.f1882a) {
                this.f1323a.showToast(atVar.d);
                if (atVar.b && atVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.f1323a.b;
                    g.i(str);
                    return;
                }
                return;
            }
            return;
        }
        if (atVar != null && atVar.b) {
            i4 = this.f1323a.k;
            if (i4 == 1) {
                arVar4 = this.f1323a.r;
                DatabaseService.m(arVar4.a().getName());
            }
        }
        blVar2 = this.f1323a.l;
        blVar2.e().g();
        FrsImageActivity frsImageActivity = this.f1323a;
        arVar = this.f1323a.r;
        frsImageActivity.a(arVar.b());
        this.f1323a.h = 30;
        arVar2 = this.f1323a.r;
        if (arVar2.c().size() > 30) {
            this.f1323a.a(FrsImageActivity.FooterType.NORMAL);
        } else {
            if (i == 1) {
                arVar3 = this.f1323a.r;
                if (arVar3.c().size() == 0) {
                    this.f1323a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1323a.a(FrsImageActivity.FooterType.LAST);
        }
        blVar3 = this.f1323a.l;
        blVar3.e().scrollTo(0, 0);
        this.f1323a.i = i;
        i2 = this.f1323a.i;
        if (i2 > 1) {
            this.f1323a.h();
        } else {
            this.f1323a.i();
        }
        i3 = this.f1323a.k;
        if (i3 == 1) {
            this.f1323a.k = 0;
            this.f1323a.getIntent().putExtra("add_search", 0);
        }
    }
}
