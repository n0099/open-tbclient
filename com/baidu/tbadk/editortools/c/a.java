package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends l {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_hot_tipc), 26, i);
        this.dxz = R.drawable.icon_pure_post_topic24_svg;
        this.dxB = true;
        this.dxC = false;
        this.dxG = new int[]{43};
    }
}
