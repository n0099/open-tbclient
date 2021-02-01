package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fCb = R.drawable.icon_pure_post_more24;
        this.fCc = R.drawable.icon_mask_post_more24_selection;
        this.fCe = false;
        this.fCf = true;
        this.fBo = new MoreDeskView(context);
        this.fCj = true;
        this.fCi = 6;
        this.fCk = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fCb = R.drawable.icon_pure_post_more24;
        this.fCc = R.drawable.icon_mask_post_more24_selection;
        this.fCe = false;
        this.fCf = true;
        this.fBo = new MoreDeskView(context, !z);
        this.fCj = true;
        this.fCi = 6;
        this.fCk = new int[]{1};
    }
}
