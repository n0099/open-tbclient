package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView RE;
    private final /* synthetic */ int RF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.RE = emotionTabContentView;
        this.RF = i;
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
        int i2 = this.RF + i;
        wVar = this.RE.RC;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            adVar = this.RE.Rp;
            dVar.setName(adVar.cG(i2));
            adVar2 = this.RE.Rp;
            dVar.a(adVar2.rr());
            adVar3 = this.RE.Rp;
            dVar.co(adVar3.getGroupName());
            adVar4 = this.RE.Rp;
            dVar.setPid(adVar4.getGroupId());
            adVar5 = this.RE.Rp;
            dVar.setWidth(adVar5.getWidth());
            adVar6 = this.RE.Rp;
            dVar.setHeight(adVar6.getHeight());
            wVar2 = this.RE.RC;
            wVar2.handleAction(20, dVar);
        }
    }
}
