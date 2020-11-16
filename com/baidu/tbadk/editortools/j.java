package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fnk = R.drawable.icon_pure_post_more24;
        this.fnl = R.drawable.icon_mask_post_more24_selection;
        this.fnn = false;
        this.fno = true;
        this.fmx = new MoreDeskView(context);
        this.fns = true;
        this.fnr = 6;
        this.fnt = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fnk = R.drawable.icon_pure_post_more24;
        this.fnl = R.drawable.icon_mask_post_more24_selection;
        this.fnn = false;
        this.fno = true;
        this.fmx = new MoreDeskView(context, !z);
        this.fns = true;
        this.fnr = 6;
        this.fnt = new int[]{1};
    }
}
