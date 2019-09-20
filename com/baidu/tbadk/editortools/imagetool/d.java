package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends k {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.ctI = R.drawable.icon_pure_post_image_n_svg;
        this.ctJ = R.drawable.icon_mask_post_image_h_svg;
        this.ctK = true;
        this.ctL = false;
        this.ctP = new int[]{14};
    }
}
