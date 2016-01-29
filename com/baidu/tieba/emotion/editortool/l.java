package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b aUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.aUU = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.k kVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.k kVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        kVar = emotionTabContentView.Lx;
        if (kVar != null) {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Ln() != null) {
                t Ln = aVar.Ln();
                int Lm = aVar.Lm();
                com.baidu.tbadk.editortools.emotiontool.c Lq = Ln.Lq();
                hVar.setName(Ln.Lq().eA(Lm + i));
                hVar.a(Lq.CT());
                hVar.dV(Lq.getGroupName());
                hVar.dW(Lq.getGroupId());
                hVar.setWidth(Lq.getWidth());
                hVar.setHeight(Lq.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                kVar2 = emotionTabContentView2.Lx;
                kVar2.b(new com.baidu.tbadk.editortools.a(24, -1, hVar));
            }
        }
    }
}
