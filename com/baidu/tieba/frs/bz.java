package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class bz implements ci {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ci
    public final void a(int i, JSONObject jSONObject, db dbVar) {
        int i2;
        cv cvVar;
        cv cvVar2;
        int i3;
        cy cyVar;
        cy cyVar2;
        FrsImageActivity.b(this.a);
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (dbVar != null && dbVar.a) {
                this.a.showToast(dbVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.h;
        frsImageActivity.h = i2 + 30;
        this.a.r = new cv();
        cvVar = this.a.r;
        cvVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        cvVar2 = this.a.r;
        FrsImageActivity.a(frsImageActivity2, cvVar2.a());
        i3 = this.a.h;
        cyVar = this.a.q;
        if (i3 >= cyVar.d().size()) {
            cyVar2 = this.a.q;
            if (cyVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
