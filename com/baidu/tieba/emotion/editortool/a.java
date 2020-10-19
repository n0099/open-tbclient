package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.eZM = R.drawable.icon_pure_post_expression24_svg;
        this.eZN = R.drawable.icon_mask_post_expression24_selection_svg;
        this.eZP = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.eYZ = emotionTabHost;
        this.eZU = true;
        this.eZT = 6;
        this.eZV = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.eZM = R.drawable.icon_pure_post_expression24_svg;
        this.eZN = R.drawable.icon_mask_post_expression24_selection_svg;
        this.eZP = true;
        this.eYZ = new EmotionTabHost(context);
        this.eZU = true;
        this.eZT = 6;
        this.eZV = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.m
    public void jI(boolean z) {
        ((EmotionTabHost) this.eYZ).setShowUserCollect(z);
    }
}
