package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView.b bVar) {
        this.bFh = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.Kg;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.VB() != null) {
                u VB = aVar.VB();
                int VA = aVar.VA();
                com.baidu.tbadk.editortools.emotiontool.c VE = VB.VE();
                lVar.setName(VB.VE().eA(VA + i));
                lVar.a(VE.CG());
                lVar.ed(VE.getGroupName());
                lVar.ee(VE.getGroupId());
                lVar.setWidth(VE.getWidth());
                lVar.setHeight(VE.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.Kg;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
