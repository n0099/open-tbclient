package com.baidu.tieba.data.emotions;

import android.view.View;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
        FacePackageDetailActivity.a(emotionImageActivity, str2, false, str);
    }
}
