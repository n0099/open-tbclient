package com.baidu.tieba.faceshop;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionImageActivity emotionImageActivity) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.n(emotionImageActivity, str2, false, str)));
    }
}
