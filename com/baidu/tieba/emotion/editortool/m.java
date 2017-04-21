package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView.b bVar) {
        this.bFa = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.KO;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Wg() != null) {
                u Wg = aVar.Wg();
                int Wf = aVar.Wf();
                com.baidu.tbadk.editortools.emotiontool.c Wj = Wg.Wj();
                lVar.setName(Wg.Wj().eE(Wf + i));
                lVar.a(Wj.DC());
                lVar.ee(Wj.getGroupName());
                lVar.ef(Wj.getGroupId());
                lVar.setWidth(Wj.getWidth());
                lVar.setHeight(Wj.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.KO;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
