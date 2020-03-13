package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends l {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.dxz = R.drawable.icon_pure_post_image24_svg;
        this.dxA = R.drawable.icon_mask_post_image24_selection_svg;
        this.dxB = true;
        this.dxC = false;
        this.dxG = new int[]{14};
    }
}
