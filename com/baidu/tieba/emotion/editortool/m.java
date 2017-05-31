package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView.b bVar) {
        this.bKW = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.JU;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.WE() != null) {
                u WE = aVar.WE();
                int WD = aVar.WD();
                com.baidu.tbadk.editortools.emotiontool.c WH = WE.WH();
                lVar.setName(WE.WH().eB(WD + i));
                lVar.a(WH.CA());
                lVar.eb(WH.getGroupName());
                lVar.ec(WH.getGroupId());
                lVar.setWidth(WH.getWidth());
                lVar.setHeight(WH.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.JU;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
