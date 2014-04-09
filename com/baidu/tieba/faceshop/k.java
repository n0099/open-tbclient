package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
final class k implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
