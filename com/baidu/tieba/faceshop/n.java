package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        String str;
        String str2;
        i = this.a.r;
        switch (i) {
            case 1:
                str = "faceshop_from_forum_detail";
                break;
            case 2:
                str = "faceshop_from_pchat_detail";
                break;
            case 3:
                str = "faceshop_from_gchat_detail";
                break;
            default:
                str = "emotion_image";
                break;
        }
        EmotionImageActivity emotionImageActivity = this.a;
        str2 = this.a.f;
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(emotionImageActivity, str2, false, str)));
    }
}
