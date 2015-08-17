package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b apM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EmotionTabContentView.b bVar) {
        this.apM = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.Kz;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.AN() != null) {
                o AN = aVar.AN();
                int AM = aVar.AM();
                v AR = AN.AR();
                fVar.setName(AN.AR().dZ(AM + i));
                fVar.a(AR.AZ());
                fVar.dC(AR.getGroupName());
                fVar.setPid(AR.getGroupId());
                fVar.setWidth(AR.getWidth());
                fVar.setHeight(AR.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.Kz;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, fVar));
            }
        }
    }
}
