package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dXy = R.drawable.icon_pure_post_expression24_svg;
        this.dXz = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dXA = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.dWM = emotionTabHost;
        this.dXE = true;
        this.dXD = 6;
        this.dXF = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dXy = R.drawable.icon_pure_post_expression24_svg;
        this.dXz = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dXA = true;
        this.dWM = new EmotionTabHost(context);
        this.dXE = true;
        this.dXD = 6;
        this.dXF = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hD(boolean z) {
        ((EmotionTabHost) this.dWM).setShowUserCollect(z);
    }
}
