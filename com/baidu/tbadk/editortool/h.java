package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionTabContentView emotionTabContentView) {
        this.a = emotionTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        aeVar = this.a.b;
        if (aeVar.c() == EmotionGroupType.BIG_EMOTION) {
            this.a.a(i, (GridView) adapterView);
            return true;
        }
        return true;
    }
}
