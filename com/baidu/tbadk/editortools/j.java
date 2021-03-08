package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fDA = R.drawable.icon_pure_post_more24;
        this.fDB = R.drawable.icon_mask_post_more24_selection;
        this.fDD = false;
        this.fDE = true;
        this.fCN = new MoreDeskView(context);
        this.fDI = true;
        this.fDH = 6;
        this.fDJ = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fDA = R.drawable.icon_pure_post_more24;
        this.fDB = R.drawable.icon_mask_post_more24_selection;
        this.fDD = false;
        this.fDE = true;
        this.fCN = new MoreDeskView(context, !z);
        this.fDI = true;
        this.fDH = 6;
        this.fDJ = new int[]{1};
    }
}
