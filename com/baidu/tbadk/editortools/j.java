package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fEu = R.drawable.icon_pure_post_more24;
        this.fEv = R.drawable.icon_mask_post_more24_selection;
        this.fEx = false;
        this.fEy = true;
        this.fDH = new MoreDeskView(context);
        this.fEC = true;
        this.fEB = 6;
        this.fED = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fEu = R.drawable.icon_pure_post_more24;
        this.fEv = R.drawable.icon_mask_post_more24_selection;
        this.fEx = false;
        this.fEy = true;
        this.fDH = new MoreDeskView(context, !z);
        this.fEC = true;
        this.fEB = 6;
        this.fED = new int[]{1};
    }
}
