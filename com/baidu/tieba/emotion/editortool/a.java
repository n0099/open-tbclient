package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.cFa = R.drawable.icon_pure_post_expression_n_svg;
        this.cFb = R.drawable.icon_mask_post_expression_h_svg;
        this.cFc = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.cEn = emotionTabHost;
        this.cFg = true;
        this.cFf = 6;
        this.cFh = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.cFa = R.drawable.icon_pure_post_expression_n_svg;
        this.cFb = R.drawable.icon_mask_post_expression_h_svg;
        this.cFc = true;
        this.cEn = new EmotionTabHost(context);
        this.cFg = true;
        this.cFf = 6;
        this.cFh = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void fh(boolean z) {
        ((EmotionTabHost) this.cEn).setShowUserCollect(z);
    }
}
