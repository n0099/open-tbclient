package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ci implements cr {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.cr
    public void a(int i, JSONObject jSONObject, dr drVar) {
        int i2;
        dl dlVar;
        dl dlVar2;
        int i3;
        Cdo cdo;
        Cdo cdo2;
        this.a.d();
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (drVar != null && drVar.a) {
                this.a.showToast(drVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.k;
        frsImageActivity.k = i2 + 30;
        this.a.u = new dl();
        dlVar = this.a.u;
        dlVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        dlVar2 = this.a.u;
        frsImageActivity2.a(dlVar2.a());
        i3 = this.a.k;
        cdo = this.a.t;
        if (i3 >= cdo.d().size()) {
            cdo2 = this.a.t;
            if (cdo2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
