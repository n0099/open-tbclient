package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dxl = R.drawable.icon_pure_post_expression24_svg;
        this.dxm = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dxn = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.dwz = emotionTabHost;
        this.dxr = true;
        this.dxq = 6;
        this.dxs = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dxl = R.drawable.icon_pure_post_expression24_svg;
        this.dxm = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dxn = true;
        this.dwz = new EmotionTabHost(context);
        this.dxr = true;
        this.dxq = 6;
        this.dxs = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void gE(boolean z) {
        ((EmotionTabHost) this.dwz).setShowUserCollect(z);
    }
}
