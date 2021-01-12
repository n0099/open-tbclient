package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fzM = R.drawable.icon_pure_post_more24;
        this.fzN = R.drawable.icon_mask_post_more24_selection;
        this.fzP = false;
        this.fzQ = true;
        this.fyZ = new MoreDeskView(context);
        this.fzU = true;
        this.fzT = 6;
        this.fzV = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fzM = R.drawable.icon_pure_post_more24;
        this.fzN = R.drawable.icon_mask_post_more24_selection;
        this.fzP = false;
        this.fzQ = true;
        this.fyZ = new MoreDeskView(context, !z);
        this.fzU = true;
        this.fzT = 6;
        this.fzV = new int[]{1};
    }
}
