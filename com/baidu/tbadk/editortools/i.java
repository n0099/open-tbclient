package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends l {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dsU = R.drawable.icon_pure_post_more24_svg;
        this.dsV = R.drawable.icon_mask_post_more24_selection_svg;
        this.dsW = true;
        this.dsh = new MoreDeskView(context);
        this.dta = true;
        this.dsZ = 6;
        this.dtb = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dsU = R.drawable.icon_pure_post_more24_svg;
        this.dsV = R.drawable.icon_mask_post_more24_selection_svg;
        this.dsW = true;
        this.dsh = new MoreDeskView(context, !z);
        this.dta = true;
        this.dsZ = 6;
        this.dtb = new int[]{1};
    }
}
