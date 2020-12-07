package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fuO = R.drawable.icon_pure_post_expression24;
        this.fuP = R.drawable.icon_pure_post_expression24_selection;
        this.fuQ = R.drawable.icon_pure_post_expression64_big;
        this.fuR = false;
        this.fuS = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fub = emotionTabHost;
        this.fuW = true;
        this.fuV = 6;
        this.fuX = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fuO = R.drawable.icon_pure_post_expression24;
        this.fuP = R.drawable.icon_pure_post_expression24_selection;
        this.fuQ = R.drawable.icon_pure_post_expression64_big;
        this.fuR = false;
        this.fuS = true;
        this.fub = new EmotionTabHost(context);
        this.fuW = true;
        this.fuV = 6;
        this.fuX = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void kv(boolean z) {
        ((EmotionTabHost) this.fub).setShowUserCollect(z);
    }
}
