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
        ag agVar;
        ag agVar2;
        ag agVar3;
        ag agVar4;
        ag agVar5;
        ag agVar6;
        x xVar2;
        adapterView.setSelection(-1);
        int i2 = this.b + i;
        xVar = this.a.p;
        if (xVar != null) {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            agVar = this.a.b;
            dVar.a(agVar.a(i2));
            agVar2 = this.a.b;
            dVar.a(agVar2.c());
            agVar3 = this.a.b;
            dVar.b(agVar3.f());
            agVar4 = this.a.b;
            dVar.c(agVar4.e());
            agVar5 = this.a.b;
            dVar.a(agVar5.g());
            agVar6 = this.a.b;
            dVar.b(agVar6.h());
            xVar2 = this.a.p;
            xVar2.a(20, dVar);
        }
    }
}
