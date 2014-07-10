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
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ae aeVar4;
        ae aeVar5;
        ae aeVar6;
        w wVar2;
        adapterView.setSelection(-1);
        int i2 = this.b + i;
        wVar = this.a.p;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            aeVar = this.a.b;
            dVar.a(aeVar.a(i2));
            aeVar2 = this.a.b;
            dVar.a(aeVar2.c());
            aeVar3 = this.a.b;
            dVar.b(aeVar3.f());
            aeVar4 = this.a.b;
            dVar.c(aeVar4.e());
            aeVar5 = this.a.b;
            dVar.a(aeVar5.g());
            aeVar6 = this.a.b;
            dVar.b(aeVar6.h());
            wVar2 = this.a.p;
            wVar2.a(20, dVar);
        }
    }
}
