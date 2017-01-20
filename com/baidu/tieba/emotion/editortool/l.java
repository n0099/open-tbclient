package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bvK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bvK = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.DX;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.TJ() != null) {
                t TJ = aVar.TJ();
                int TI = aVar.TI();
                com.baidu.tbadk.editortools.emotiontool.c TM = TJ.TM();
                lVar.setName(TJ.TM().eG(TI + i));
                lVar.a(TM.CM());
                lVar.ee(TM.getGroupName());
                lVar.ef(TM.getGroupId());
                lVar.setWidth(TM.getWidth());
                lVar.setHeight(TM.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.DX;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
