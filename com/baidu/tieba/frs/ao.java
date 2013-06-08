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
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.c.ab abVar) {
        int i2;
        com.baidu.tieba.c.y yVar;
        com.baidu.tieba.c.y yVar2;
        int i3;
        com.baidu.tieba.c.z zVar;
        com.baidu.tieba.c.z zVar2;
        this.a.a(aw.NORMAL);
        if (jSONObject == null) {
            if (abVar != null && abVar.a) {
                this.a.a(abVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.a;
        i2 = frsImageActivity.i;
        frsImageActivity.i = i2 + 30;
        this.a.u = new com.baidu.tieba.c.y();
        yVar = this.a.u;
        yVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.a;
        yVar2 = this.a.u;
        frsImageActivity2.a(yVar2.a());
        i3 = this.a.i;
        zVar = this.a.t;
        if (i3 >= zVar.c().size()) {
            zVar2 = this.a.t;
            if (zVar2.d() == 0) {
                this.a.a(aw.LAST);
            } else {
                this.a.a(aw.NEXT);
            }
        }
    }
}
