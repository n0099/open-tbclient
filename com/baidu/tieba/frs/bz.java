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
    public final void a(int i, JSONObject jSONObject, dd ddVar) {
        int i2;
        cx cxVar;
        cx cxVar2;
        int i3;
        da daVar;
        da daVar2;
        FrsImageActivity.b(this.a);
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (ddVar != null && ddVar.a) {
                this.a.showToast(ddVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.h;
        frsImageActivity.h = i2 + 30;
        this.a.r = new cx();
        cxVar = this.a.r;
        cxVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        cxVar2 = this.a.r;
        FrsImageActivity.a(frsImageActivity2, cxVar2.a());
        i3 = this.a.h;
        daVar = this.a.q;
        if (i3 >= daVar.d().size()) {
            daVar2 = this.a.q;
            if (daVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
