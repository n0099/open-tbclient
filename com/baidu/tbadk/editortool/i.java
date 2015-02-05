package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView Yi;
    private final /* synthetic */ int Yj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.Yi = emotionTabContentView;
        this.Yj = i;
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
        int i2 = this.Yj + i;
        wVar = this.Yi.Yg;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            aeVar = this.Yi.XT;
            fVar.setName(aeVar.dl(i2));
            aeVar2 = this.Yi.XT;
            fVar.a(aeVar2.vf());
            aeVar3 = this.Yi.XT;
            fVar.dd(aeVar3.getGroupName());
            aeVar4 = this.Yi.XT;
            fVar.setPid(aeVar4.getGroupId());
            aeVar5 = this.Yi.XT;
            fVar.setWidth(aeVar5.getWidth());
            aeVar6 = this.Yi.XT;
            fVar.setHeight(aeVar6.getHeight());
            wVar2 = this.Yi.Yg;
            wVar2.handleAction(20, fVar);
        }
    }
}
