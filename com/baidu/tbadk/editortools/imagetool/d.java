package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends m {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.fDA = R.drawable.icon_pure_post_image24;
        this.fDB = R.drawable.icon_pure_post_image24_selection;
        this.fDC = R.drawable.icon_post_image24_big;
        this.fDD = false;
        this.fDE = true;
        this.fDF = false;
        this.fDJ = new int[]{14};
    }
}
