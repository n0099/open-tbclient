package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends k {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.cFa = R.drawable.icon_pure_post_more_n_svg;
        this.cFb = R.drawable.icon_mask_post_more_h_svg;
        this.cFc = true;
        this.cEn = new MoreDeskView(context);
        this.cFg = true;
        this.cFf = 6;
        this.cFh = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.cFa = R.drawable.icon_pure_post_more_n_svg;
        this.cFb = R.drawable.icon_mask_post_more_h_svg;
        this.cFc = true;
        this.cEn = new MoreDeskView(context, !z);
        this.cFg = true;
        this.cFf = 6;
        this.cFh = new int[]{1};
    }
}
