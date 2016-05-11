package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b aVH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.aVH = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.l lVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.l lVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        lVar = emotionTabContentView.BV;
        if (lVar != null) {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.LK() != null) {
                t LK = aVar.LK();
                int LJ = aVar.LJ();
                com.baidu.tbadk.editortools.emotiontool.c LN = LK.LN();
                hVar.setName(LK.LN().el(LJ + i));
                hVar.a(LN.Bv());
                hVar.dY(LN.getGroupName());
                hVar.dZ(LN.getGroupId());
                hVar.setWidth(LN.getWidth());
                hVar.setHeight(LN.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.BV;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, hVar));
            }
        }
    }
}
