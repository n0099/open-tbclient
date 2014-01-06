package com.baidu.tieba.editortool;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ EmotionTabContentView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionTabContentView emotionTabContentView, int i) {
        this.b = emotionTabContentView;
        this.a = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar;
        WritableEmotionGroup writableEmotionGroup;
        WritableEmotionGroup writableEmotionGroup2;
        WritableEmotionGroup writableEmotionGroup3;
        WritableEmotionGroup writableEmotionGroup4;
        t tVar2;
        adapterView.setSelection(-1);
        int i2 = this.a + i;
        tVar = this.b.p;
        if (tVar != null) {
            q qVar = new q();
            writableEmotionGroup = this.b.b;
            qVar.a(writableEmotionGroup.a(i2));
            writableEmotionGroup2 = this.b.b;
            qVar.a(writableEmotionGroup2.c());
            writableEmotionGroup3 = this.b.b;
            qVar.b(writableEmotionGroup3.f());
            writableEmotionGroup4 = this.b.b;
            qVar.c(writableEmotionGroup4.e());
            tVar2 = this.b.p;
            tVar2.a(20, qVar);
        }
    }
}
