package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b aOY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.aOY = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.k kVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.k kVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        kVar = emotionTabContentView.KS;
        if (kVar != null) {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Ji() != null) {
                t Ji = aVar.Ji();
                int Jh = aVar.Jh();
                com.baidu.tbadk.editortools.emotiontool.c Jl = Ji.Jl();
                hVar.setName(Ji.Jl().el(Jh + i));
                hVar.a(Jl.BN());
                hVar.dU(Jl.getGroupName());
                hVar.setPid(Jl.getGroupId());
                hVar.setWidth(Jl.getWidth());
                hVar.setHeight(Jl.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                kVar2 = emotionTabContentView2.KS;
                kVar2.b(new com.baidu.tbadk.editortools.a(24, -1, hVar));
            }
        }
    }
}
