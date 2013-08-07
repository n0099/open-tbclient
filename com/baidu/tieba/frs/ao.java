package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ao implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1063a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.f1063a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        this.f1063a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.am amVar) {
        int i2;
        com.baidu.tieba.model.ag agVar;
        com.baidu.tieba.model.ag agVar2;
        int i3;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        this.f1063a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (amVar != null && amVar.f1329a) {
                this.f1063a.a(amVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.f1063a;
        i2 = frsImageActivity.g;
        frsImageActivity.g = i2 + 30;
        this.f1063a.u = new com.baidu.tieba.model.ag();
        agVar = this.f1063a.u;
        agVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.f1063a;
        agVar2 = this.f1063a.u;
        frsImageActivity2.a(agVar2.a());
        i3 = this.f1063a.g;
        akVar = this.f1063a.t;
        if (i3 >= akVar.c().size()) {
            akVar2 = this.f1063a.t;
            if (akVar2.d() == 0) {
                this.f1063a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.f1063a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
