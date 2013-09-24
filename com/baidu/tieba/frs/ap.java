package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ap implements ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsImageActivity frsImageActivity) {
        this.f1126a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i) {
        this.f1126a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.ax
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.ao aoVar) {
        int i2;
        com.baidu.tieba.model.ai aiVar;
        com.baidu.tieba.model.ai aiVar2;
        int i3;
        com.baidu.tieba.model.am amVar;
        com.baidu.tieba.model.am amVar2;
        this.f1126a.c();
        this.f1126a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (aoVar != null && aoVar.f1401a) {
                this.f1126a.a(aoVar.d);
                return;
            }
            return;
        }
        FrsImageActivity frsImageActivity = this.f1126a;
        i2 = frsImageActivity.g;
        frsImageActivity.g = i2 + 30;
        this.f1126a.t = new com.baidu.tieba.model.ai();
        aiVar = this.f1126a.t;
        aiVar.a(jSONObject);
        FrsImageActivity frsImageActivity2 = this.f1126a;
        aiVar2 = this.f1126a.t;
        frsImageActivity2.a(aiVar2.a());
        i3 = this.f1126a.g;
        amVar = this.f1126a.s;
        if (i3 >= amVar.c().size()) {
            amVar2 = this.f1126a.s;
            if (amVar2.d() == 0) {
                this.f1126a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.f1126a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
