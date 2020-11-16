package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fnk = R.drawable.icon_pure_post_expression24;
        this.fnl = R.drawable.icon_pure_post_expression24_selection;
        this.fnm = R.drawable.icon_pure_post_expression64_big;
        this.fnn = false;
        this.fno = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fmx = emotionTabHost;
        this.fns = true;
        this.fnr = 6;
        this.fnt = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fnk = R.drawable.icon_pure_post_expression24;
        this.fnl = R.drawable.icon_pure_post_expression24_selection;
        this.fnm = R.drawable.icon_pure_post_expression64_big;
        this.fnn = false;
        this.fno = true;
        this.fmx = new EmotionTabHost(context);
        this.fns = true;
        this.fnr = 6;
        this.fnt = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void kf(boolean z) {
        ((EmotionTabHost) this.fmx).setShowUserCollect(z);
    }
}
