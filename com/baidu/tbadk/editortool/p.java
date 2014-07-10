package com.baidu.tbadk.editortool;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final int b;

    private p(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.a = emotionTabHorizonScrollView;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, p pVar) {
        this(emotionTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionTabHorizonScrollView.a(this.a).a(this.b);
    }
}
