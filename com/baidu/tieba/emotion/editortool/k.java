package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EmotionTabContentView.b bVar) {
        this.aKy = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.j jVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.j jVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        jVar = emotionTabContentView.KB;
        if (jVar != null) {
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.HP() != null) {
                s HP = aVar.HP();
                int HO = aVar.HO();
                com.baidu.tbadk.editortools.emotiontool.c HS = HP.HS();
                fVar.setName(HP.HS().dX(HO + i));
                fVar.a(HS.AP());
                fVar.dM(HS.getGroupName());
                fVar.setPid(HS.getGroupId());
                fVar.setWidth(HS.getWidth());
                fVar.setHeight(HS.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                jVar2 = emotionTabContentView2.KB;
                jVar2.b(new com.baidu.tbadk.editortools.a(24, -1, fVar));
            }
        }
    }
}
