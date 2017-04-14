package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView.b bCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabContentView.b bVar) {
        this.bCJ = bVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
        if (aVar == null || aVar.Vf() == null) {
            return false;
        }
        if (aVar.Vf().Vj() == EmotionGroupType.BIG_EMOTION) {
            emotionTabContentView = EmotionTabContentView.this;
            emotionTabContentView.a(i, (GridView) adapterView);
            return true;
        }
        return false;
    }
}
