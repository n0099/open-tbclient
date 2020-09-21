package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_at), 9, i);
        this.eNF = R.drawable.ic_icon_pure_post_at24;
        this.eNH = R.drawable.icon_pure_more_at40_svg;
        this.eNI = true;
        this.eNK = true;
        this.eNO = new int[]{16};
    }
}
