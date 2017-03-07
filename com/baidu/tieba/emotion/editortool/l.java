package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bCQ = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.Ll;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.UH() != null) {
                t UH = aVar.UH();
                int UG = aVar.UG();
                com.baidu.tbadk.editortools.emotiontool.c UK = UH.UK();
                lVar.setName(UH.UK().eB(UG + i));
                lVar.a(UK.De());
                lVar.dY(UK.getGroupName());
                lVar.dZ(UK.getGroupId());
                lVar.setWidth(UK.getWidth());
                lVar.setHeight(UK.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.Ll;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
