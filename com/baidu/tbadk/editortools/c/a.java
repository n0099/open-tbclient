package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.eLk = R.drawable.ic_icon_pure_post_link24_svg;
        this.eLn = true;
        this.eLp = false;
        this.eLt = new int[]{21};
    }
}
