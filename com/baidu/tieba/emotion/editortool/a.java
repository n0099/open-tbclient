package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.foc = R.drawable.icon_pure_post_expression24_svg;
        this.fod = R.drawable.icon_mask_post_expression24_selection_svg;
        this.fof = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.fnp = emotionTabHost;
        this.fok = true;
        this.foj = 6;
        this.fol = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.foc = R.drawable.icon_pure_post_expression24_svg;
        this.fod = R.drawable.icon_mask_post_expression24_selection_svg;
        this.fof = true;
        this.fnp = new EmotionTabHost(context);
        this.fok = true;
        this.foj = 6;
        this.fol = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void ke(boolean z) {
        ((EmotionTabHost) this.fnp).setShowUserCollect(z);
    }
}
