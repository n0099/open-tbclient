package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class cg implements cp {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cp
    public void a(int i, JSONObject jSONObject, dm dmVar) {
        int i2;
        dg dgVar;
        dg dgVar2;
        int i3;
        dj djVar;
        dj djVar2;
        this.a.d();
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (dmVar != null && dmVar.a) {
                this.a.showToast(dmVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.j;
        frsImageActivity.j = i2 + 30;
        this.a.t = new dg();
        dgVar = this.a.t;
        dgVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        dgVar2 = this.a.t;
        frsImageActivity2.a(dgVar2.a());
        i3 = this.a.j;
        djVar = this.a.s;
        if (i3 >= djVar.d().size()) {
            djVar2 = this.a.s;
            if (djVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
