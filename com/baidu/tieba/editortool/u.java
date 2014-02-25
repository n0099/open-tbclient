package com.baidu.tieba.editortool;

import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final int b;

    private u(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.a = emotionTabHorizonScrollView;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, u uVar) {
        this(emotionTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionTabHorizonScrollView.a(this.a).a(this.b);
    }
}
