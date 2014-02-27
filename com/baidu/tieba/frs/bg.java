package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class bg implements bo {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bo
    public final void a() {
        this.a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.bo
    public final void a(int i, JSONObject jSONObject, com.baidu.tieba.model.an anVar) {
        int i2;
        com.baidu.tieba.model.af afVar;
        com.baidu.tieba.model.af afVar2;
        int i3;
        com.baidu.tieba.model.al alVar;
        com.baidu.tieba.model.al alVar2;
        FrsImageActivity.c(this.a);
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (anVar != null && anVar.a) {
                this.a.showToast(anVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.h;
        frsImageActivity.h = i2 + 30;
        this.a.r = new com.baidu.tieba.model.af();
        afVar = this.a.r;
        afVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        afVar2 = this.a.r;
        FrsImageActivity.a(frsImageActivity2, afVar2.a());
        i3 = this.a.h;
        alVar = this.a.q;
        if (i3 >= alVar.d().size()) {
            alVar2 = this.a.q;
            if (alVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
