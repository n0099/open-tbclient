package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends m {
    public l(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.fuO = R.drawable.icon_pure_post_more_title24;
        this.fuQ = R.drawable.icon_pure_post_more_tittle64;
        this.fuR = false;
        this.fuS = true;
        this.fuT = false;
        this.fuX = new int[]{56};
    }
}
