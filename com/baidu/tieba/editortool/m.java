package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView emotionTabContentView) {
        this.a = emotionTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        WritableEmotionGroup writableEmotionGroup;
        writableEmotionGroup = this.a.b;
        if (writableEmotionGroup.c() == WritableEmotionGroup.EmotionGroupType.BIG_EMOTION) {
            this.a.a(i, (GridView) adapterView);
            return true;
        }
        return true;
    }
}
