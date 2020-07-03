package com.baidu.tbadk.editortools.a;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends l {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_at), 9, i);
        this.eut = R.drawable.ic_icon_pure_post_at24;
        this.euv = R.drawable.icon_pure_more_at40_svg;
        this.euw = true;
        this.eux = true;
        this.euB = new int[]{16};
    }
}
