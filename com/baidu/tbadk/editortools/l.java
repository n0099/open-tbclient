package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends m {
    public l(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.fzM = R.drawable.icon_pure_post_more_title24;
        this.fzO = R.drawable.icon_pure_post_more_tittle64;
        this.fzP = false;
        this.fzQ = true;
        this.fzR = false;
        this.fzV = new int[]{56};
    }
}
