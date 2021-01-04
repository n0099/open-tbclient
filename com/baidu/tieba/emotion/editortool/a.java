package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fEu = R.drawable.icon_pure_post_expression24;
        this.fEv = R.drawable.icon_pure_post_expression24_selection;
        this.fEw = R.drawable.icon_pure_post_expression64_big;
        this.fEx = false;
        this.fEy = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fDH = emotionTabHost;
        this.fEC = true;
        this.fEB = 6;
        this.fED = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fEu = R.drawable.icon_pure_post_expression24;
        this.fEv = R.drawable.icon_pure_post_expression24_selection;
        this.fEw = R.drawable.icon_pure_post_expression64_big;
        this.fEx = false;
        this.fEy = true;
        this.fDH = new EmotionTabHost(context);
        this.fEC = true;
        this.fEB = 6;
        this.fED = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void kR(boolean z) {
        ((EmotionTabHost) this.fDH).setShowUserCollect(z);
    }
}
