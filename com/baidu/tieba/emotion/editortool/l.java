package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b aZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.aZD = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.l lVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.l lVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        lVar = emotionTabContentView.LE;
        if (lVar != null) {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Nb() != null) {
                t Nb = aVar.Nb();
                int Na = aVar.Na();
                com.baidu.tbadk.editortools.emotiontool.c Ne = Nb.Ne();
                hVar.setName(Nb.Ne().eF(Na + i));
                hVar.a(Ne.DB());
                hVar.ec(Ne.getGroupName());
                hVar.ed(Ne.getGroupId());
                hVar.setWidth(Ne.getWidth());
                hVar.setHeight(Ne.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.LE;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, hVar));
            }
        }
    }
}
