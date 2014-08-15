package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ch implements cq {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cq
    public void a(int i, JSONObject jSONObject, dp dpVar) {
        int i2;
        dj djVar;
        dj djVar2;
        int i3;
        dm dmVar;
        dm dmVar2;
        this.a.d();
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (dpVar != null && dpVar.a) {
                this.a.showToast(dpVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.k;
        frsImageActivity.k = i2 + 30;
        this.a.u = new dj();
        djVar = this.a.u;
        djVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        djVar2 = this.a.u;
        frsImageActivity2.a(djVar2.a());
        i3 = this.a.k;
        dmVar = this.a.t;
        if (i3 >= dmVar.d().size()) {
            dmVar2 = this.a.t;
            if (dmVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
