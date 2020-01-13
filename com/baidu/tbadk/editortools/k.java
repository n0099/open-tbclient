package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class k extends l {
    public k(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.dtf = R.drawable.icon_pure_more_title40_svg;
        this.dth = true;
        this.dti = false;
        this.dtm = new int[]{56};
    }
}
