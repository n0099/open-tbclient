package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends m {
    public l(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.eZM = R.drawable.ic_icon_pure_more_title24_svg;
        this.eZO = R.drawable.icon_pure_more_title40_svg;
        this.eZP = true;
        this.eZR = false;
        this.eZV = new int[]{56};
    }
}
