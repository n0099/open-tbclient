package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ EmotionTabContentView.b bRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView.b bVar) {
        this.bRu = bVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmotionTabContentView emotionTabContentView;
        EmotionTabContentView.a aVar = (EmotionTabContentView.a) adapterView.getAdapter();
        if (aVar == null || aVar.aaa() == null) {
            return false;
        }
        w aaa = aVar.aaa();
        if (aaa.aae() == EmotionGroupType.BIG_EMOTION || aaa.aae() == EmotionGroupType.USER_COLLECT) {
            emotionTabContentView = EmotionTabContentView.this;
            emotionTabContentView.a(i, (GridView) adapterView);
            return true;
        }
        return false;
    }
}
