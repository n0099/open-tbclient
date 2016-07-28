package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b btD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.btD = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.l lVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.l lVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        lVar = emotionTabContentView.Cw;
        if (lVar != null) {
            com.baidu.tbadk.coreExtra.data.i iVar = new com.baidu.tbadk.coreExtra.data.i();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.RV() != null) {
                t RV = aVar.RV();
                int RU = aVar.RU();
                com.baidu.tbadk.editortools.emotiontool.c RY = RV.RY();
                iVar.setName(RV.RY().eo(RU + i));
                iVar.a(RY.BF());
                iVar.eb(RY.getGroupName());
                iVar.ec(RY.getGroupId());
                iVar.setWidth(RY.getWidth());
                iVar.setHeight(RY.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.Cw;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, iVar));
            }
        }
    }
}
