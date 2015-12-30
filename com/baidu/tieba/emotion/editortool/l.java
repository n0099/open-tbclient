package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b aSQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.aSQ = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.k kVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.k kVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        kVar = emotionTabContentView.Li;
        if (kVar != null) {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Jz() != null) {
                t Jz = aVar.Jz();
                int Jy = aVar.Jy();
                com.baidu.tbadk.editortools.emotiontool.c JC = Jz.JC();
                hVar.setName(Jz.JC().ef(Jy + i));
                hVar.a(JC.BC());
                hVar.dX(JC.getGroupName());
                hVar.setPid(JC.getGroupId());
                hVar.setWidth(JC.getWidth());
                hVar.setHeight(JC.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                kVar2 = emotionTabContentView2.Li;
                kVar2.b(new com.baidu.tbadk.editortools.a(24, -1, hVar));
            }
        }
    }
}
