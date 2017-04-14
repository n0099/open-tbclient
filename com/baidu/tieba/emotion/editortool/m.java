package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView.b bVar) {
        this.bCJ = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.KM;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Vf() != null) {
                u Vf = aVar.Vf();
                int Ve = aVar.Ve();
                com.baidu.tbadk.editortools.emotiontool.c Vi = Vf.Vi();
                lVar.setName(Vf.Vi().eE(Ve + i));
                lVar.a(Vi.DC());
                lVar.ee(Vi.getGroupName());
                lVar.ef(Vi.getGroupId());
                lVar.setWidth(Vi.getWidth());
                lVar.setHeight(Vi.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.KM;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, lVar));
            }
        }
    }
}
