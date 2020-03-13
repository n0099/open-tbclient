package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends l {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dxz = R.drawable.icon_pure_post_more24_svg;
        this.dxA = R.drawable.icon_mask_post_more24_selection_svg;
        this.dxB = true;
        this.dwN = new MoreDeskView(context);
        this.dxF = true;
        this.dxE = 6;
        this.dxG = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dxz = R.drawable.icon_pure_post_more24_svg;
        this.dxA = R.drawable.icon_mask_post_more24_selection_svg;
        this.dxB = true;
        this.dwN = new MoreDeskView(context, !z);
        this.dxF = true;
        this.dxE = 6;
        this.dxG = new int[]{1};
    }
}
