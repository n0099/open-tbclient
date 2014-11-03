package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity asB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EmotionImageActivity emotionImageActivity) {
        this.asB = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.asB.finish();
    }
}
