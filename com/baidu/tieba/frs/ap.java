package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ap implements ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1259a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsImageActivity frsImageActivity) {
        this.f1259a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i) {
        this.f1259a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.aw awVar) {
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        int i2;
        com.baidu.tieba.model.au auVar;
        com.baidu.tieba.model.au auVar2;
        this.f1259a.c();
        this.f1259a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (awVar != null && awVar.f1906a) {
                this.f1259a.a(awVar.d);
                return;
            }
            return;
        }
        FrsImageActivity.d(this.f1259a, 30);
        this.f1259a.t = new com.baidu.tieba.model.aq();
        aqVar = this.f1259a.t;
        aqVar.a(jSONObject);
        FrsImageActivity frsImageActivity = this.f1259a;
        aqVar2 = this.f1259a.t;
        frsImageActivity.a(aqVar2.a());
        i2 = this.f1259a.g;
        auVar = this.f1259a.s;
        if (i2 >= auVar.c().size()) {
            auVar2 = this.f1259a.s;
            if (auVar2.d() == 0) {
                this.f1259a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.f1259a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
