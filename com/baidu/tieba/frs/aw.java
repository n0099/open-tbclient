package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class aw implements bo {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bo
    public final void a() {
        boolean z;
        bq bqVar;
        z = this.a.p;
        if (!z) {
            bqVar = this.a.l;
            bqVar.a(true);
            return;
        }
        this.a.p = false;
    }

    @Override // com.baidu.tieba.frs.bo
    public final void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        bq bqVar;
        bq bqVar2;
        com.baidu.tieba.model.al alVar;
        com.baidu.tieba.model.al alVar2;
        bq bqVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.al alVar3;
        int i4;
        com.baidu.tieba.model.al alVar4;
        com.baidu.tieba.model.al alVar5;
        bq bqVar4;
        com.baidu.tieba.model.al alVar6;
        com.baidu.tieba.model.al alVar7;
        bq bqVar5;
        String str;
        FrsImageActivity.c(this.a);
        bqVar = this.a.l;
        bqVar.a(false);
        this.a.a();
        if (jSONObject == null) {
            if (anVar.a) {
                this.a.showToast(anVar.d);
                if (anVar.b && anVar.c == 2000) {
                    TiebaApplication g = TiebaApplication.g();
                    str = this.a.b;
                    g.i(str);
                }
            }
        } else {
            if (anVar != null && anVar.b) {
                i4 = this.a.k;
                if (i4 == 1) {
                    alVar4 = this.a.q;
                    DatabaseService.h(alVar4.b().getName());
                }
            }
            bqVar2 = this.a.l;
            bqVar2.e().c();
            FrsImageActivity frsImageActivity = this.a;
            alVar = this.a.q;
            FrsImageActivity.a(frsImageActivity, alVar.c());
            this.a.h = 30;
            alVar2 = this.a.q;
            if (alVar2.d().size() <= 30) {
                if (i == 1) {
                    alVar3 = this.a.q;
                    if (alVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            }
            bqVar3 = this.a.l;
            bqVar3.e().scrollTo(0, 0);
            this.a.i = i;
            i2 = this.a.i;
            if (i2 > 1) {
                FrsImageActivity.h(this.a);
            } else {
                this.a.l.e().b();
            }
            i3 = this.a.k;
            if (i3 == 1) {
                this.a.k = 0;
                this.a.getIntent().putExtra("add_search", 0);
            }
        }
        alVar5 = this.a.q;
        if (alVar5 != null) {
            alVar6 = this.a.q;
            if (alVar6.a() != null) {
                alVar7 = this.a.q;
                if (alVar7.a().a()) {
                    bqVar5 = this.a.l;
                    bqVar5.c(true);
                    return;
                }
            }
        }
        bqVar4 = this.a.l;
        bqVar4.c(false);
    }
}
