package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.util.DatabaseService;
import org.json.JSONObject;
/* loaded from: classes.dex */
class av implements bn {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bn
    public void a(int i) {
        boolean z;
        bp bpVar;
        z = this.a.p;
        if (!z) {
            bpVar = this.a.l;
            bpVar.a(true);
            return;
        }
        this.a.p = false;
    }

    @Override // com.baidu.tieba.frs.bn
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        bp bpVar;
        bp bpVar2;
        com.baidu.tieba.model.al alVar;
        com.baidu.tieba.model.al alVar2;
        bp bpVar3;
        int i2;
        int i3;
        com.baidu.tieba.model.al alVar3;
        int i4;
        com.baidu.tieba.model.al alVar4;
        com.baidu.tieba.model.al alVar5;
        bp bpVar4;
        com.baidu.tieba.model.al alVar6;
        com.baidu.tieba.model.al alVar7;
        bp bpVar5;
        String str;
        this.a.d();
        bpVar = this.a.l;
        bpVar.a(false);
        this.a.a("done");
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
                    DatabaseService.j(alVar4.b().getName());
                }
            }
            bpVar2 = this.a.l;
            bpVar2.e().i();
            FrsImageActivity frsImageActivity = this.a;
            alVar = this.a.q;
            frsImageActivity.a(alVar.c());
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
            bpVar3 = this.a.l;
            bpVar3.e().scrollTo(0, 0);
            this.a.i = i;
            i2 = this.a.i;
            if (i2 > 1) {
                this.a.i();
            } else {
                this.a.j();
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
                    bpVar5 = this.a.l;
                    bpVar5.c(true);
                    return;
                }
            }
        }
        bpVar4 = this.a.l;
        bpVar4.c(false);
    }
}
