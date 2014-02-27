package com.baidu.tieba.data.emotions;

import android.view.View;
/* loaded from: classes.dex */
final class f implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
