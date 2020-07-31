package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends l {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eAM = R.drawable.icon_pure_post_more24_svg;
        this.eAN = R.drawable.icon_mask_post_more24_selection_svg;
        this.eAP = true;
        this.ezZ = new MoreDeskView(context);
        this.eAT = true;
        this.eAS = 6;
        this.eAU = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eAM = R.drawable.icon_pure_post_more24_svg;
        this.eAN = R.drawable.icon_mask_post_more24_selection_svg;
        this.eAP = true;
        this.ezZ = new MoreDeskView(context, !z);
        this.eAT = true;
        this.eAS = 6;
        this.eAU = new int[]{1};
    }
}
