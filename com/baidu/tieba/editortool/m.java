package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ EmotionTabContentView a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabContentView emotionTabContentView, int i) {
        this.a = emotionTabContentView;
        this.b = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        z zVar;
        WritableEmotionGroup writableEmotionGroup;
        WritableEmotionGroup writableEmotionGroup2;
        WritableEmotionGroup writableEmotionGroup3;
        WritableEmotionGroup writableEmotionGroup4;
        WritableEmotionGroup writableEmotionGroup5;
        WritableEmotionGroup writableEmotionGroup6;
        z zVar2;
        adapterView.setSelection(-1);
        int i2 = this.b + i;
        zVar = this.a.p;
        if (zVar != null) {
            w wVar = new w();
            writableEmotionGroup = this.a.b;
            wVar.a(writableEmotionGroup.a(i2));
            writableEmotionGroup2 = this.a.b;
            wVar.a(writableEmotionGroup2.c());
            writableEmotionGroup3 = this.a.b;
            wVar.b(writableEmotionGroup3.f());
            writableEmotionGroup4 = this.a.b;
            wVar.c(writableEmotionGroup4.e());
            writableEmotionGroup5 = this.a.b;
            wVar.a(writableEmotionGroup5.g());
            writableEmotionGroup6 = this.a.b;
            wVar.b(writableEmotionGroup6.h());
            zVar2 = this.a.p;
            zVar2.a(20, wVar);
        }
    }
}
