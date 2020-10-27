package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends m {
    public l(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.fij = R.drawable.ic_icon_pure_more_title24_svg;
        this.fil = R.drawable.icon_pure_more_title40_svg;
        this.fim = true;
        this.fio = false;
        this.fit = new int[]{56};
    }
}
