package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends k {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.ctI = R.drawable.icon_pure_post_expression_n_svg;
        this.ctJ = R.drawable.icon_mask_post_expression_h_svg;
        this.ctK = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.csV = emotionTabHost;
        this.ctO = true;
        this.ctN = 6;
        this.ctP = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.ctI = R.drawable.icon_pure_post_expression_n_svg;
        this.ctJ = R.drawable.icon_mask_post_expression_h_svg;
        this.ctK = true;
        this.csV = new EmotionTabHost(context);
        this.ctO = true;
        this.ctN = 6;
        this.ctP = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.k
    public void fn(boolean z) {
        ((EmotionTabHost) this.csV).setShowUserCollect(z);
    }
}
