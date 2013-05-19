package com.baidu.tieba.frs;

import org.json.JSONObject;
/* loaded from: classes.dex */
class ao implements ax {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i) {
        this.a.a(aw.LOADING);
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.c.y yVar) {
        int i2;
        com.baidu.tieba.c.v vVar;
        com.baidu.tieba.c.v vVar2;
        int i3;
        com.baidu.tieba.c.w wVar;
        com.baidu.tieba.c.w wVar2;
        this.a.a(aw.NORMAL);
        if (jSONObject == null) {
            if (yVar != null && yVar.a) {
                this.a.a(yVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.i;
        frsImageActivity.i = i2 + 30;
        this.a.u = new com.baidu.tieba.c.v();
        vVar = this.a.u;
        vVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        vVar2 = this.a.u;
        frsImageActivity2.a(vVar2.a());
        i3 = this.a.i;
        wVar = this.a.t;
        if (i3 >= wVar.c().size()) {
            wVar2 = this.a.t;
            if (wVar2.d() == 0) {
                this.a.a(aw.LAST);
            } else {
                this.a.a(aw.NEXT);
            }
        }
    }
}
