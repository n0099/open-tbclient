package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fCb = R.drawable.icon_pure_post_expression24;
        this.fCc = R.drawable.icon_pure_post_expression24_selection;
        this.fCd = R.drawable.icon_pure_post_expression64_big;
        this.fCe = false;
        this.fCf = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fBo = emotionTabHost;
        this.fCj = true;
        this.fCi = 6;
        this.fCk = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fCb = R.drawable.icon_pure_post_expression24;
        this.fCc = R.drawable.icon_pure_post_expression24_selection;
        this.fCd = R.drawable.icon_pure_post_expression64_big;
        this.fCe = false;
        this.fCf = true;
        this.fBo = new EmotionTabHost(context);
        this.fCj = true;
        this.fCi = 6;
        this.fCk = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void kQ(boolean z) {
        ((EmotionTabHost) this.fBo).setShowUserCollect(z);
    }
}
