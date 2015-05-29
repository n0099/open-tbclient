package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ g ajD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.ajD = gVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        e eVar = (e) adapterView.getAdapter();
        if (eVar == null || eVar.zq() == null) {
            return false;
        }
        if (eVar.zq().zu() == EmotionGroupType.BIG_EMOTION) {
            emotionTabContentView = this.ajD.ajA;
            emotionTabContentView.a(i, (GridView) adapterView);
            return true;
        }
        return false;
    }
}
