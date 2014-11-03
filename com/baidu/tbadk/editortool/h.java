package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView RI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionTabContentView emotionTabContentView) {
        this.RI = emotionTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar;
        adVar = this.RI.Rt;
        if (adVar.rt() == EmotionGroupType.BIG_EMOTION) {
            this.RI.a(i, (GridView) adapterView);
            return true;
        }
        return false;
    }
}
