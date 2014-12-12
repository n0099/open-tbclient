package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView XF;
    private final /* synthetic */ int XG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.XF = emotionTabContentView;
        this.XG = i;
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
        int i2 = this.XG + i;
        wVar = this.XF.XD;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            aeVar = this.XF.Xq;
            fVar.setName(aeVar.de(i2));
            aeVar2 = this.XF.Xq;
            fVar.a(aeVar2.uU());
            aeVar3 = this.XF.Xq;
            fVar.dh(aeVar3.getGroupName());
            aeVar4 = this.XF.Xq;
            fVar.setPid(aeVar4.getGroupId());
            aeVar5 = this.XF.Xq;
            fVar.setWidth(aeVar5.getWidth());
            aeVar6 = this.XF.Xq;
            fVar.setHeight(aeVar6.getHeight());
            wVar2 = this.XF.XD;
            wVar2.handleAction(20, fVar);
        }
    }
}
