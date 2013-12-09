package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class as implements bk {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsImageActivity frsImageActivity) {
        this.f1374a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        boolean z;
        bl blVar;
        z = this.f1374a.q;
        if (z) {
            this.f1374a.q = false;
            return;
        }
        blVar = this.f1374a.l;
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
        this.f1374a.d();
        blVar = this.f1374a.l;
        blVar.a(false);
        this.f1374a.a("done");
        if (jSONObject == null) {
            if (atVar.f1995a) {
                this.f1374a.showToast(atVar.d);
                if (atVar.b && atVar.c == 2000) {
                    TiebaApplication h = TiebaApplication.h();
                    str = this.f1374a.b;
                    h.j(str);
                    return;
                }
                return;
            }
            return;
        }
        if (atVar != null && atVar.b) {
            i4 = this.f1374a.k;
            if (i4 == 1) {
                arVar4 = this.f1374a.r;
                DatabaseService.k(arVar4.a().getName());
            }
        }
        blVar2 = this.f1374a.l;
        blVar2.e().g();
        FrsImageActivity frsImageActivity = this.f1374a;
        arVar = this.f1374a.r;
        frsImageActivity.a(arVar.b());
        this.f1374a.h = 30;
        arVar2 = this.f1374a.r;
        if (arVar2.c().size() > 30) {
            this.f1374a.a(FrsImageActivity.FooterType.NORMAL);
        } else {
            if (i == 1) {
                arVar3 = this.f1374a.r;
                if (arVar3.c().size() == 0) {
                    this.f1374a.a(FrsImageActivity.FooterType.NO_ITEM);
                }
            }
            this.f1374a.a(FrsImageActivity.FooterType.LAST);
        }
        blVar3 = this.f1374a.l;
        blVar3.e().scrollTo(0, 0);
        this.f1374a.i = i;
        i2 = this.f1374a.i;
        if (i2 > 1) {
            this.f1374a.h();
        } else {
            this.f1374a.i();
        }
        i3 = this.f1374a.k;
        if (i3 == 1) {
            this.f1374a.k = 0;
            this.f1374a.getIntent().putExtra("add_search", 0);
        }
    }
}
