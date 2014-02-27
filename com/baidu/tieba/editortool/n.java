package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabContentView emotionTabContentView, int i) {
        this.a = emotionTabContentView;
        this.b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        aa aaVar;
        WritableEmotionGroup writableEmotionGroup;
        WritableEmotionGroup writableEmotionGroup2;
        WritableEmotionGroup writableEmotionGroup3;
        WritableEmotionGroup writableEmotionGroup4;
        WritableEmotionGroup writableEmotionGroup5;
        WritableEmotionGroup writableEmotionGroup6;
        aa aaVar2;
        adapterView.setSelection(-1);
        int i2 = this.b + i;
        aaVar = this.a.p;
        if (aaVar != null) {
            x xVar = new x();
            writableEmotionGroup = this.a.b;
            xVar.a(writableEmotionGroup.a(i2));
            writableEmotionGroup2 = this.a.b;
            xVar.a(writableEmotionGroup2.c());
            writableEmotionGroup3 = this.a.b;
            xVar.b(writableEmotionGroup3.f());
            writableEmotionGroup4 = this.a.b;
            xVar.c(writableEmotionGroup4.e());
            writableEmotionGroup5 = this.a.b;
            xVar.a(writableEmotionGroup5.g());
            writableEmotionGroup6 = this.a.b;
            xVar.b(writableEmotionGroup6.h());
            aaVar2 = this.a.p;
            aaVar2.a(20, xVar);
        }
    }
}
