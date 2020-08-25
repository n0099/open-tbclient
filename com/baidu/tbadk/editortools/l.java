package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class l extends m {
    public l(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.eLk = R.drawable.ic_icon_pure_more_title24_svg;
        this.eLm = R.drawable.icon_pure_more_title40_svg;
        this.eLn = true;
        this.eLp = false;
        this.eLt = new int[]{56};
    }
}
