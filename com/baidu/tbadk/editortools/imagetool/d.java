package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends l {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.elH = R.drawable.icon_pure_post_image24_svg;
        this.elI = R.drawable.icon_mask_post_image24_selection_svg;
        this.elJ = true;
        this.elK = false;
        this.elO = new int[]{14};
    }
}
