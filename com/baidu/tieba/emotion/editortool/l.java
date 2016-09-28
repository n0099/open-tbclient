package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bFa = bVar;
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
            if (aVar != null && aVar.Xa() != null) {
                t Xa = aVar.Xa();
                int WZ = aVar.WZ();
                com.baidu.tbadk.editortools.emotiontool.c Xd = Xa.Xd();
                lVar3.setName(Xa.Xd().eB(WZ + i));
                lVar3.a(Xd.Da());
                lVar3.eh(Xd.getGroupName());
                lVar3.ei(Xd.getGroupId());
                lVar3.setWidth(Xd.getWidth());
                lVar3.setHeight(Xd.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.EJ;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar3));
            }
        }
    }
}
