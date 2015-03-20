package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ g aiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.aiv = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        v vVar;
        EmotionTabContentView emotionTabContentView2;
        v vVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = this.aiv.ais;
        vVar = emotionTabContentView.aip;
        if (vVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            e eVar = (e) adapterView.getAdapter();
            if (eVar != null && eVar.yx() != null) {
                u yx = eVar.yx();
                int yw = eVar.yw();
                ad yA = yx.yA();
                fVar.setName(yx.yA().dz(yw + i));
                fVar.a(yA.yI());
                fVar.dj(yA.getGroupName());
                fVar.setPid(yA.getGroupId());
                fVar.setWidth(yA.getWidth());
                fVar.setHeight(yA.getHeight());
                emotionTabContentView2 = this.aiv.ais;
                vVar2 = emotionTabContentView2.aip;
                vVar2.handleAction(20, fVar);
            }
        }
    }
}
