package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fDA = R.drawable.icon_pure_post_expression24;
        this.fDB = R.drawable.icon_pure_post_expression24_selection;
        this.fDC = R.drawable.icon_pure_post_expression64_big;
        this.fDD = false;
        this.fDE = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fCN = emotionTabHost;
        this.fDI = true;
        this.fDH = 6;
        this.fDJ = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.fDA = R.drawable.icon_pure_post_expression24;
        this.fDB = R.drawable.icon_pure_post_expression24_selection;
        this.fDC = R.drawable.icon_pure_post_expression64_big;
        this.fDD = false;
        this.fDE = true;
        this.fCN = new EmotionTabHost(context);
        this.fDI = true;
        this.fDH = 6;
        this.fDJ = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void kQ(boolean z) {
        ((EmotionTabHost) this.fCN).setShowUserCollect(z);
    }
}
