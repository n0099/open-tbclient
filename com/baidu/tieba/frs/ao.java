package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.by;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements bg {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bg
    public void a(int i) {
        boolean z;
        bi biVar;
        z = this.a.p;
        if (z) {
            this.a.p = false;
            return;
        }
        biVar = this.a.l;
        biVar.a(true);
    }

    @Override // com.baidu.tieba.frs.bg
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        long j;
        bi biVar;
        bi biVar2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        bi biVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.ar arVar3;
        int i4;
        com.baidu.tieba.model.ar arVar4;
        com.baidu.tieba.model.ar arVar5;
        bi biVar4;
        com.baidu.tieba.model.ar arVar6;
        com.baidu.tieba.model.ar arVar7;
        bi biVar5;
        String str;
        long j2;
        j = this.a.v;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.v;
            by.a(currentTimeMillis - j2);
            this.a.v = -1L;
        }
        this.a.d();
        biVar = this.a.l;
        biVar.a(false);
        this.a.a("done");
        if (jSONObject == null) {
            if (atVar.a) {
                this.a.showToast(atVar.d);
                if (atVar.b && atVar.c == 2000) {
                    TiebaApplication h = TiebaApplication.h();
                    str = this.a.b;
                    h.i(str);
                }
            }
        } else {
            if (atVar != null && atVar.b) {
                i4 = this.a.k;
                if (i4 == 1) {
                    arVar4 = this.a.q;
                    DatabaseService.m(arVar4.b().getName());
                }
            }
            biVar2 = this.a.l;
            biVar2.e().g();
            FrsImageActivity frsImageActivity = this.a;
            arVar = this.a.q;
            frsImageActivity.a(arVar.c());
            this.a.h = 30;
            arVar2 = this.a.q;
            if (arVar2.d().size() > 30) {
                this.a.a(FrsImageActivity.FooterType.NORMAL);
            } else {
                if (i == 1) {
                    arVar3 = this.a.q;
                    if (arVar3.d().size() == 0) {
                        this.a.a(FrsImageActivity.FooterType.NO_ITEM);
                    }
                }
                this.a.a(FrsImageActivity.FooterType.LAST);
            }
            biVar3 = this.a.l;
            biVar3.e().scrollTo(0, 0);
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
        arVar5 = this.a.q;
        if (arVar5 != null) {
            arVar6 = this.a.q;
            if (arVar6.a() != null) {
                arVar7 = this.a.q;
                if (arVar7.a().a()) {
                    biVar5 = this.a.l;
                    biVar5.c(true);
                    return;
                }
            }
        }
        biVar4 = this.a.l;
        biVar4.c(false);
    }
}
