package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dxz = R.drawable.icon_pure_post_expression24_svg;
        this.dxA = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dxB = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.dwN = emotionTabHost;
        this.dxF = true;
        this.dxE = 6;
        this.dxG = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dxz = R.drawable.icon_pure_post_expression24_svg;
        this.dxA = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dxB = true;
        this.dwN = new EmotionTabHost(context);
        this.dxF = true;
        this.dxE = 6;
        this.dxG = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void gE(boolean z) {
        ((EmotionTabHost) this.dwN).setShowUserCollect(z);
    }
}
