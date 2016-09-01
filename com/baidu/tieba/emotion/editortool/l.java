package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bEP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bEP = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.l lVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.l lVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        lVar = emotionTabContentView.EJ;
        if (lVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar3 = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.WH() != null) {
                t WH = aVar.WH();
                int WG = aVar.WG();
                com.baidu.tbadk.editortools.emotiontool.c WK = WH.WK();
                lVar3.setName(WH.WK().eC(WG + i));
                lVar3.a(WK.Da());
                lVar3.ee(WK.getGroupName());
                lVar3.ef(WK.getGroupId());
                lVar3.setWidth(WK.getWidth());
                lVar3.setHeight(WK.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.EJ;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar3));
            }
        }
    }
}
