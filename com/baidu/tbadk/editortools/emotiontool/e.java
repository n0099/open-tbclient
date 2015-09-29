package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView;
/* loaded from: classes.dex */
class e implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView.b apW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EmotionTabContentView.b bVar) {
        this.apW = bVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
        if (aVar == null || aVar.AN() == null) {
            return false;
        }
        if (aVar.AN().AS() == EmotionGroupType.BIG_EMOTION) {
            emotionTabContentView = EmotionTabContentView.this;
            emotionTabContentView.a(i, (GridView) adapterView);
            return true;
        }
        return false;
    }
}
