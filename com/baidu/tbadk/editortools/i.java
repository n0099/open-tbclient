package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.cFR = R.drawable.icon_pure_post_more_n_svg;
        this.cFS = R.drawable.icon_mask_post_more_h_svg;
        this.cFT = true;
        this.cFe = new MoreDeskView(context);
        this.cFX = true;
        this.cFW = 6;
        this.cFY = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.cFR = R.drawable.icon_pure_post_more_n_svg;
        this.cFS = R.drawable.icon_mask_post_more_h_svg;
        this.cFT = true;
        this.cFe = new MoreDeskView(context, !z);
        this.cFX = true;
        this.cFW = 6;
        this.cFY = new int[]{1};
    }
}
