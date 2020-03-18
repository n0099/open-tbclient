package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends l {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dxM = R.drawable.icon_pure_post_more24_svg;
        this.dxN = R.drawable.icon_mask_post_more24_selection_svg;
        this.dxO = true;
        this.dxa = new MoreDeskView(context);
        this.dxS = true;
        this.dxR = 6;
        this.dxT = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.dxM = R.drawable.icon_pure_post_more24_svg;
        this.dxN = R.drawable.icon_mask_post_more24_selection_svg;
        this.dxO = true;
        this.dxa = new MoreDeskView(context, !z);
        this.dxS = true;
        this.dxR = 6;
        this.dxT = new int[]{1};
    }
}
