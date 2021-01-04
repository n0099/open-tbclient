package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_at), 9, i);
        this.fEu = R.drawable.icon_pure_post_at24;
        this.fEw = R.drawable.icon_pure_post_more_at64;
        this.fEx = false;
        this.fEy = true;
        this.fEz = true;
        this.fED = new int[]{16};
    }
}
