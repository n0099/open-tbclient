package com.baidu.tbadk.editortool;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    private final int Ha;
    final /* synthetic */ EmotionTabHorizonScrollView Yy;

    private p(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i) {
        this.Yy = emotionTabHorizonScrollView;
        this.Ha = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, p pVar) {
        this(emotionTabHorizonScrollView, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionTabHorizonScrollView.a(this.Yy).dm(this.Ha);
    }
}
