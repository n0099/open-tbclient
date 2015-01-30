package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView Yl;
    private final /* synthetic */ int Ym;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView, int i) {
        this.Yl = emotionTabContentView;
        this.Ym = i;
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
        int i2 = this.Ym + i;
        wVar = this.Yl.Yj;
        if (wVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            aeVar = this.Yl.XW;
            fVar.setName(aeVar.dl(i2));
            aeVar2 = this.Yl.XW;
            fVar.a(aeVar2.vl());
            aeVar3 = this.Yl.XW;
            fVar.dg(aeVar3.getGroupName());
            aeVar4 = this.Yl.XW;
            fVar.setPid(aeVar4.getGroupId());
            aeVar5 = this.Yl.XW;
            fVar.setWidth(aeVar5.getWidth());
            aeVar6 = this.Yl.XW;
            fVar.setHeight(aeVar6.getHeight());
            wVar2 = this.Yl.Yj;
            wVar2.handleAction(20, fVar);
        }
    }
}
