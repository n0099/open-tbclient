package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dsU = R.drawable.icon_pure_post_expression24_svg;
        this.dsV = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dsW = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.dsh = emotionTabHost;
        this.dta = true;
        this.dsZ = 6;
        this.dtb = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.dsU = R.drawable.icon_pure_post_expression24_svg;
        this.dsV = R.drawable.icon_mask_post_expression24_selection_svg;
        this.dsW = true;
        this.dsh = new EmotionTabHost(context);
        this.dta = true;
        this.dsZ = 6;
        this.dtb = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void gs(boolean z) {
        ((EmotionTabHost) this.dsh).setShowUserCollect(z);
    }
}
