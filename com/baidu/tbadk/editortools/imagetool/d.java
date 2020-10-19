package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends m {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.eZM = R.drawable.icon_pure_post_image24_svg;
        this.eZN = R.drawable.icon_mask_image_selection24_svg;
        this.eZP = true;
        this.eZR = false;
        this.eZV = new int[]{14};
    }
}
