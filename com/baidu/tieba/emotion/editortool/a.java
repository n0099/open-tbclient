package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dxm = R.drawable.icon_pure_post_expression24_svg;
        this.dxn = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dxo = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.dwA = emotionTabHost;
        this.dxs = true;
        this.dxr = 6;
        this.dxt = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dxm = R.drawable.icon_pure_post_expression24_svg;
        this.dxn = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dxo = true;
        this.dwA = new EmotionTabHost(context);
        this.dxs = true;
        this.dxr = 6;
        this.dxt = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void gE(boolean z) {
        ((EmotionTabHost) this.dwA).setShowUserCollect(z);
    }
}
