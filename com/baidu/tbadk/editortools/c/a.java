package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_hot_tipc), 26, i);
        this.ctI = R.drawable.icon_pure_post_topic_n_svg;
        this.ctK = true;
        this.ctL = false;
        this.ctP = new int[]{43};
    }
}
