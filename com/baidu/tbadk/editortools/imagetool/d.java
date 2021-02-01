package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class d extends m {
    public d(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_image), 10, i);
        this.fCb = R.drawable.icon_pure_post_image24;
        this.fCc = R.drawable.icon_pure_post_image24_selection;
        this.fCd = R.drawable.icon_post_image24_big;
        this.fCe = false;
        this.fCf = true;
        this.fCg = false;
        this.fCk = new int[]{14};
    }
}
