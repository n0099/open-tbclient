package com.baidu.tieba.editortool;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, l lVar) {
        this(emotionTabHorizonScrollView, i);
    }

    private o(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.a = emotionTabHorizonScrollView;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        sVar = this.a.d;
        sVar.a(this.b);
    }
}
