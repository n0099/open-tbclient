package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fzM = R.drawable.icon_pure_post_expression24;
        this.fzN = R.drawable.icon_pure_post_expression24_selection;
        this.fzO = R.drawable.icon_pure_post_expression64_big;
        this.fzP = false;
        this.fzQ = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fyZ = emotionTabHost;
        this.fzU = true;
        this.fzT = 6;
        this.fzV = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fzM = R.drawable.icon_pure_post_expression24;
        this.fzN = R.drawable.icon_pure_post_expression24_selection;
        this.fzO = R.drawable.icon_pure_post_expression64_big;
        this.fzP = false;
        this.fzQ = true;
        this.fyZ = new EmotionTabHost(context);
        this.fzU = true;
        this.fzT = 6;
        this.fzV = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void kN(boolean z) {
        ((EmotionTabHost) this.fyZ).setShowUserCollect(z);
    }
}
