package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ao implements aw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f841a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.f841a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i) {
        this.f841a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.aw
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ae aeVar) {
        int i2;
        com.baidu.tieba.model.ab abVar;
        com.baidu.tieba.model.ab abVar2;
        int i3;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        this.f841a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (aeVar != null && aeVar.f1011a) {
                this.f841a.a(aeVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.f841a;
        i2 = frsImageActivity.g;
        frsImageActivity.g = i2 + 30;
        this.f841a.u = new com.baidu.tieba.model.ab();
        abVar = this.f841a.u;
        abVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.f841a;
        abVar2 = this.f841a.u;
        frsImageActivity2.a(abVar2.a());
        i3 = this.f841a.g;
        acVar = this.f841a.t;
        if (i3 >= acVar.c().size()) {
            acVar2 = this.f841a.t;
            if (acVar2.d() == 0) {
                this.f841a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.f841a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
