package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends l {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_link), 31, i);
        this.eut = R.drawable.ic_icon_pure_post_link24_svg;
        this.euw = true;
        this.eux = false;
        this.euB = new int[]{21};
    }
}
