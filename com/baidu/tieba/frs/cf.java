package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class cf implements cp {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cp
    public void a(int i, JSONObject jSONObject, dl dlVar) {
        int i2;
        df dfVar;
        df dfVar2;
        int i3;
        di diVar;
        di diVar2;
        this.a.d();
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (dlVar != null && dlVar.a) {
                this.a.showToast(dlVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.k;
        frsImageActivity.k = i2 + 30;
        this.a.u = new df();
        dfVar = this.a.u;
        dfVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        dfVar2 = this.a.u;
        frsImageActivity2.a(dfVar2.a());
        i3 = this.a.k;
        diVar = this.a.t;
        if (i3 >= diVar.d().size()) {
            diVar2 = this.a.t;
            if (diVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
