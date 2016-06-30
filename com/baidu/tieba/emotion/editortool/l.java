package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView.b bro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bro = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        com.baidu.tbadk.editortools.l lVar;
        EmotionTabContentView emotionTabContentView2;
        com.baidu.tbadk.editortools.l lVar2;
        adapterView.setSelection(-1);
        emotionTabContentView = EmotionTabContentView.this;
        lVar = emotionTabContentView.BW;
        if (lVar != null) {
            com.baidu.tbadk.coreExtra.data.i iVar = new com.baidu.tbadk.coreExtra.data.i();
            EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
            if (aVar != null && aVar.Ro() != null) {
                t Ro = aVar.Ro();
                int Rn = aVar.Rn();
                com.baidu.tbadk.editortools.emotiontool.c Rr = Ro.Rr();
                iVar.setName(Ro.Rr().eo(Rn + i));
                iVar.a(Rr.BF());
                iVar.ec(Rr.getGroupName());
                iVar.ed(Rr.getGroupId());
                iVar.setWidth(Rr.getWidth());
                iVar.setHeight(Rr.getHeight());
                emotionTabContentView2 = EmotionTabContentView.this;
                lVar2 = emotionTabContentView2.BW;
                lVar2.b(new com.baidu.tbadk.editortools.a(24, -1, iVar));
            }
        }
    }
}
