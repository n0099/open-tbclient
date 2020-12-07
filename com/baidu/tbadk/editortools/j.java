package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fuO = R.drawable.icon_pure_post_more24;
        this.fuP = R.drawable.icon_mask_post_more24_selection;
        this.fuR = false;
        this.fuS = true;
        this.fub = new MoreDeskView(context);
        this.fuW = true;
        this.fuV = 6;
        this.fuX = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fuO = R.drawable.icon_pure_post_more24;
        this.fuP = R.drawable.icon_mask_post_more24_selection;
        this.fuR = false;
        this.fuS = true;
        this.fub = new MoreDeskView(context, !z);
        this.fuW = true;
        this.fuV = 6;
        this.fuX = new int[]{1};
    }
}
