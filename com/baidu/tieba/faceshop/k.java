package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity ass;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EmotionImageActivity emotionImageActivity) {
        this.ass = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ass.finish();
    }
}
