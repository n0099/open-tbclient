package com.baidu.tbadk.editortool;

import android.view.View;
/* loaded from: classes.dex */
final class q implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView a;
    private final int b;

    private q(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.a = emotionTabHorizonScrollView;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, byte b) {
        this(emotionTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EmotionTabHorizonScrollView.a(this.a).a(this.b);
    }
}
