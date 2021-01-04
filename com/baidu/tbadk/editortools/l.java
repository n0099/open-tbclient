package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l extends m {
    public l(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_add_title), 30, i);
        this.fEu = R.drawable.icon_pure_post_more_title24;
        this.fEw = R.drawable.icon_pure_post_more_tittle64;
        this.fEx = false;
        this.fEy = true;
        this.fEz = false;
        this.fED = new int[]{56};
    }
}
