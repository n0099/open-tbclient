package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b apX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EmotionTabContentView.b bVar) {
        this.apX = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.KA;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.AK() != null) {
                o AK = aVar.AK();
                int AJ = aVar.AJ();
                t AO = AK.AO();
                fVar.setName(AK.AO().ei(AJ + i));
                fVar.a(AO.AW());
                fVar.dM(AO.getGroupName());
                fVar.setPid(AO.getGroupId());
                fVar.setWidth(AO.getWidth());
                fVar.setHeight(AO.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.KA;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, fVar));
            }
        }
    }
}
