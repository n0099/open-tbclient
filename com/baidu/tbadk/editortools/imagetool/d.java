package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends k {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.cFR = R.drawable.icon_pure_post_image_n_svg;
        this.cFS = R.drawable.icon_mask_post_image_h_svg;
        this.cFT = true;
        this.cFU = false;
        this.cFY = new int[]{14};
    }
}
