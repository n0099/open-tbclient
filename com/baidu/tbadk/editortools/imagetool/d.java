package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends m {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.fij = R.drawable.icon_pure_post_image24_svg;
        this.fik = R.drawable.icon_mask_image_selection24_svg;
        this.fim = true;
        this.fio = false;
        this.fit = new int[]{14};
    }
}
