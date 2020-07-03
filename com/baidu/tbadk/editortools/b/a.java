package com.baidu.tbadk.editortools.b;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends l {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_gift_tab), 22, i);
        this.eut = R.drawable.icon_pure_post_gift24_svg;
        this.euw = true;
        this.euB = new int[]{36};
    }
}
