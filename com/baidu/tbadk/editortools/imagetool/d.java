package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends l {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.eAM = R.drawable.icon_pure_post_image24_svg;
        this.eAN = R.drawable.icon_mask_image_selection24_svg;
        this.eAP = true;
        this.eAQ = false;
        this.eAU = new int[]{14};
    }
}
