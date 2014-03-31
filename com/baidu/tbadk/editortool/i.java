package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.a = emotionTabContentView;
        this.b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        af afVar;
        af afVar2;
        af afVar3;
        af afVar4;
        af afVar5;
        af afVar6;
        x xVar2;
        adapterView.setSelection(-1);
        int i2 = this.b + i;
        xVar = this.a.p;
        if (xVar != null) {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            afVar = this.a.b;
            dVar.a(afVar.a(i2));
            afVar2 = this.a.b;
            dVar.a(afVar2.c());
            afVar3 = this.a.b;
            dVar.b(afVar3.f());
            afVar4 = this.a.b;
            dVar.c(afVar4.e());
            afVar5 = this.a.b;
            dVar.a(afVar5.g());
            afVar6 = this.a.b;
            dVar.b(afVar6.h());
            xVar2 = this.a.p;
            xVar2.a(20, dVar);
        }
    }
}
