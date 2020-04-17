package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends l {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dXt = R.drawable.icon_pure_post_more24_svg;
        this.dXu = R.drawable.icon_mask_post_more24_selection_svg;
        this.dXv = true;
        this.dWH = new MoreDeskView(context);
        this.dXz = true;
        this.dXy = 6;
        this.dXA = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dXt = R.drawable.icon_pure_post_more24_svg;
        this.dXu = R.drawable.icon_mask_post_more24_selection_svg;
        this.dXv = true;
        this.dWH = new MoreDeskView(context, !z);
        this.dXz = true;
        this.dXy = 6;
        this.dXA = new int[]{1};
    }
}
