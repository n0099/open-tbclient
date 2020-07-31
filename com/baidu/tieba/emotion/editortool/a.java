package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.eAM = R.drawable.icon_pure_post_expression24_svg;
        this.eAN = R.drawable.icon_mask_post_expression24_selection_svg;
        this.eAP = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.ezZ = emotionTabHost;
        this.eAT = true;
        this.eAS = 6;
        this.eAU = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.eAM = R.drawable.icon_pure_post_expression24_svg;
        this.eAN = R.drawable.icon_mask_post_expression24_selection_svg;
        this.eAP = true;
        this.ezZ = new EmotionTabHost(context);
        this.eAT = true;
        this.eAS = 6;
        this.eAU = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void iM(boolean z) {
        ((EmotionTabHost) this.ezZ).setShowUserCollect(z);
    }
}
