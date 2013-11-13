package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bc implements bk {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FrsImageActivity frsImageActivity) {
        this.f1329a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        this.f1329a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        int i2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        this.f1329a.d();
        this.f1329a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (atVar != null && atVar.f1900a) {
                this.f1329a.showToast(atVar.d);
                return;
            }
            return;
        }
        FrsImageActivity.d(this.f1329a, 30);
        this.f1329a.s = new com.baidu.tieba.model.aq();
        aqVar = this.f1329a.s;
        aqVar.a(jSONObject);
        FrsImageActivity frsImageActivity = this.f1329a;
        aqVar2 = this.f1329a.s;
        frsImageActivity.a(aqVar2.a());
        i2 = this.f1329a.h;
        arVar = this.f1329a.r;
        if (i2 >= arVar.c().size()) {
            arVar2 = this.f1329a.r;
            if (arVar2.d() == 0) {
                this.f1329a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.f1329a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
