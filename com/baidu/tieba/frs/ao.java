package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ao implements aw {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        this.a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ae aeVar) {
        int i2;
        com.baidu.tieba.model.ab abVar;
        com.baidu.tieba.model.ab abVar2;
        int i3;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (aeVar != null && aeVar.a) {
                this.a.a(aeVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.g;
        frsImageActivity.g = i2 + 30;
        this.a.u = new com.baidu.tieba.model.ab();
        abVar = this.a.u;
        abVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        abVar2 = this.a.u;
        frsImageActivity2.a(abVar2.a());
        i3 = this.a.g;
        acVar = this.a.t;
        if (i3 >= acVar.c().size()) {
            acVar2 = this.a.t;
            if (acVar2.d() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
