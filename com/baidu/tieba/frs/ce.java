package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ce implements co {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.co
    public void a(int i, JSONObject jSONObject, dk dkVar) {
        int i2;
        de deVar;
        de deVar2;
        int i3;
        dh dhVar;
        dh dhVar2;
        this.a.d();
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (dkVar != null && dkVar.a) {
                this.a.showToast(dkVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.k;
        frsImageActivity.k = i2 + 30;
        this.a.u = new de();
        deVar = this.a.u;
        deVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        deVar2 = this.a.u;
        frsImageActivity2.a(deVar2.a());
        i3 = this.a.k;
        dhVar = this.a.t;
        if (i3 >= dhVar.d().size()) {
            dhVar2 = this.a.t;
            if (dhVar2.e() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
