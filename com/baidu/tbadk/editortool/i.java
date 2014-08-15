package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.a = emotionTabContentView;
        this.b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        w wVar;
        ad adVar;
        ad adVar2;
        ad adVar3;
        ad adVar4;
        ad adVar5;
        ad adVar6;
        w wVar2;
        adapterView.setSelection(-1);
        int i2 = this.b + i;
        wVar = this.a.p;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            adVar = this.a.b;
            dVar.a(adVar.a(i2));
            adVar2 = this.a.b;
            dVar.a(adVar2.c());
            adVar3 = this.a.b;
            dVar.b(adVar3.f());
            adVar4 = this.a.b;
            dVar.c(adVar4.e());
            adVar5 = this.a.b;
            dVar.a(adVar5.g());
            adVar6 = this.a.b;
            dVar.b(adVar6.h());
            wVar2 = this.a.p;
            wVar2.a(20, dVar);
        }
    }
}
