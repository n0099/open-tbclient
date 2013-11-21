package com.baidu.tieba.frs;

import com.baidu.tieba.frs.FrsImageActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
class bc implements bk {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FrsImageActivity frsImageActivity) {
        this.f1334a = frsImageActivity;
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i) {
        this.f1334a.a(FrsImageActivity.FooterType.LOADING);
    }

    @Override // com.baidu.tieba.frs.bk
    public void a(int i, JSONObject jSONObject, com.baidu.tieba.model.at atVar) {
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        int i2;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        this.f1334a.d();
        this.f1334a.a(FrsImageActivity.FooterType.NORMAL);
        if (jSONObject == null) {
            if (atVar != null && atVar.f1882a) {
                this.f1334a.showToast(atVar.d);
                return;
            }
            return;
        }
        FrsImageActivity.d(this.f1334a, 30);
        this.f1334a.s = new com.baidu.tieba.model.aq();
        aqVar = this.f1334a.s;
        aqVar.a(jSONObject);
        FrsImageActivity frsImageActivity = this.f1334a;
        aqVar2 = this.f1334a.s;
        frsImageActivity.a(aqVar2.a());
        i2 = this.f1334a.h;
        arVar = this.f1334a.r;
        if (i2 >= arVar.c().size()) {
            arVar2 = this.f1334a.r;
            if (arVar2.d() == 0) {
                this.f1334a.a(FrsImageActivity.FooterType.LAST);
            } else {
                this.f1334a.a(FrsImageActivity.FooterType.NEXT);
            }
        }
    }
}
