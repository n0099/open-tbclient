package com.baidu.tieba.faceshop;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity ass;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionImageActivity emotionImageActivity) {
        this.ass = emotionImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        String str;
        String str2;
        i = this.ass.from;
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
        EmotionImageActivity emotionImageActivity = this.ass;
        str2 = this.ass.Lh;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(emotionImageActivity, str2, false, str)));
    }
}
