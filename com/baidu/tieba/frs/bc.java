package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bc implements bk {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        this.a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        int i2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        this.a.d();
        this.a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (atVar != null && atVar.a) {
                this.a.showToast(atVar.d);
                return;
            }
            return;
        }
        FrsImageActivity.d(this.a, 30);
        this.a.s = new com.baidu.tieba.model.aq();
        aqVar = this.a.s;
        aqVar.a(jSONObject);
        FrsImageActivity frsImageActivity = this.a;
        aqVar2 = this.a.s;
        frsImageActivity.a(aqVar2.a());
        i2 = this.a.h;
        arVar = this.a.r;
        if (i2 >= arVar.c().size()) {
            arVar2 = this.a.r;
            if (arVar2.d() == 0) {
                this.a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
