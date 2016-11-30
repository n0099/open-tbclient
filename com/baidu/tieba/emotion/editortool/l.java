package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bHU = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.l lVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.l lVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        lVar = emotionTabContentView.EL;
        if (lVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar3 = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Yc() != null) {
                t Yc = aVar.Yc();
                int Yb = aVar.Yb();
                com.baidu.tbadk.editortools.emotiontool.c Yf = Yc.Yf();
                lVar3.setName(Yc.Yf().eE(Yb + i));
                lVar3.a(Yf.Di());
                lVar3.ej(Yf.getGroupName());
                lVar3.ek(Yf.getGroupId());
                lVar3.setWidth(Yf.getWidth());
                lVar3.setHeight(Yf.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.EL;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar3));
            }
        }
    }
}
