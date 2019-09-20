package com.baidu.tbadk.editortools.b;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_gift_tab), 22, i);
        this.ctI = R.drawable.icon_pure_post_gift_n_svg;
        this.ctK = true;
        this.ctP = new int[]{36};
    }
}
