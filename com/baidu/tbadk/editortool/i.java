package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ g aiD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.aiD = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        v vVar;
        EmotionTabContentView emotionTabContentView2;
        v vVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = this.aiD.aiA;
        vVar = emotionTabContentView.aix;
        if (vVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            e eVar = (e) adapterView.getAdapter();
            if (eVar != null && eVar.yD() != null) {
                u yD = eVar.yD();
                int yC = eVar.yC();
                ad yG = yD.yG();
                fVar.setName(yD.yG().dz(yC + i));
                fVar.a(yG.yO());
                fVar.dj(yG.getGroupName());
                fVar.setPid(yG.getGroupId());
                fVar.setWidth(yG.getWidth());
                fVar.setHeight(yG.getHeight());
                emotionTabContentView2 = this.aiD.aiA;
                vVar2 = emotionTabContentView2.aix;
                vVar2.handleAction(20, fVar);
            }
        }
    }
}
