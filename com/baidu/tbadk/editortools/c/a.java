package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.fnk = R.drawable.icon_pure_post_link24;
        this.fnn = false;
        this.fno = true;
        this.fnp = false;
        this.fnt = new int[]{21};
    }
}
