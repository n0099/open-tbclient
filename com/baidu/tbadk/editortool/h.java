package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView Yi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionTabContentView emotionTabContentView) {
        this.Yi = emotionTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        aeVar = this.Yi.XT;
        if (aeVar.vf() == EmotionGroupType.BIG_EMOTION) {
            this.Yi.a(i, (GridView) adapterView);
            return true;
        }
        return false;
    }
}
