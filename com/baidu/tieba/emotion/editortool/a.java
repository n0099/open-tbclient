package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends l {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.elH = R.drawable.icon_pure_post_expression24_svg;
        this.elI = R.drawable.icon_mask_post_expression24_selection_svg;
        this.elJ = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.ekV = emotionTabHost;
        this.elN = true;
        this.elM = 6;
        this.elO = new int[]{1, 34, 35};
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.elH = R.drawable.icon_pure_post_expression24_svg;
        this.elI = R.drawable.icon_mask_post_expression24_selection_svg;
        this.elJ = true;
        this.ekV = new EmotionTabHost(context);
        this.elN = true;
        this.elM = 6;
        this.elO = new int[]{1, 34, 35};
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hZ(boolean z) {
        ((EmotionTabHost) this.ekV).setShowUserCollect(z);
    }
}
