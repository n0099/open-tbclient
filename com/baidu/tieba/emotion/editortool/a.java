package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.eLo = R.drawable.icon_pure_post_expression24_svg;
        this.eLp = R.drawable.icon_mask_post_expression24_selection_svg;
        this.eLr = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.eKB = emotionTabHost;
        this.eLw = true;
        this.eLv = 6;
        this.eLx = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.eLo = R.drawable.icon_pure_post_expression24_svg;
        this.eLp = R.drawable.icon_mask_post_expression24_selection_svg;
        this.eLr = true;
        this.eKB = new EmotionTabHost(context);
        this.eLw = true;
        this.eLv = 6;
        this.eLx = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void jm(boolean z) {
        ((EmotionTabHost) this.eKB).setShowUserCollect(z);
    }
}
