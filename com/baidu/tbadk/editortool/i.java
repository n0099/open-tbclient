package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView RI;
    private final /* synthetic */ int RJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.RI = emotionTabContentView;
        this.RJ = i;
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
        int i2 = this.RJ + i;
        wVar = this.RI.RG;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            adVar = this.RI.Rt;
            dVar.setName(adVar.cG(i2));
            adVar2 = this.RI.Rt;
            dVar.a(adVar2.rt());
            adVar3 = this.RI.Rt;
            dVar.co(adVar3.getGroupName());
            adVar4 = this.RI.Rt;
            dVar.setPid(adVar4.getGroupId());
            adVar5 = this.RI.Rt;
            dVar.setWidth(adVar5.getWidth());
            adVar6 = this.RI.Rt;
            dVar.setHeight(adVar6.getHeight());
            wVar2 = this.RI.RG;
            wVar2.handleAction(20, dVar);
        }
    }
}
