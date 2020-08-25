package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_at), 9, i);
        this.eLk = R.drawable.ic_icon_pure_post_at24;
        this.eLm = R.drawable.icon_pure_more_at40_svg;
        this.eLn = true;
        this.eLp = true;
        this.eLt = new int[]{16};
    }
}
