package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dXt = R.drawable.icon_pure_post_expression24_svg;
        this.dXu = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dXv = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.dWH = emotionTabHost;
        this.dXz = true;
        this.dXy = 6;
        this.dXA = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dXt = R.drawable.icon_pure_post_expression24_svg;
        this.dXu = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dXv = true;
        this.dWH = new EmotionTabHost(context);
        this.dXz = true;
        this.dXy = 6;
        this.dXA = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hD(boolean z) {
        ((EmotionTabHost) this.dWH).setShowUserCollect(z);
    }
}
