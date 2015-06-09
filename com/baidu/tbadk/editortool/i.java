package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ g ajD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.ajD = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        v vVar;
        EmotionTabContentView emotionTabContentView2;
        v vVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = this.ajD.ajA;
        vVar = emotionTabContentView.ajx;
        if (vVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            e eVar = (e) adapterView.getAdapter();
            if (eVar != null && eVar.zr() != null) {
                u zr = eVar.zr();
                int zq = eVar.zq();
                ad zu = zr.zu();
                fVar.setName(zr.zu().dI(zq + i));
                fVar.a(zu.zC());
                fVar.dA(zu.getGroupName());
                fVar.setPid(zu.getGroupId());
                fVar.setWidth(zu.getWidth());
                fVar.setHeight(zu.getHeight());
                emotionTabContentView2 = this.ajD.ajA;
                vVar2 = emotionTabContentView2.ajx;
                vVar2.handleAction(20, fVar);
            }
        }
    }
}
