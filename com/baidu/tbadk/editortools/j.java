package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.foc = R.drawable.icon_pure_post_more24_svg;
        this.fod = R.drawable.icon_mask_post_more24_selection_svg;
        this.fof = true;
        this.fnp = new MoreDeskView(context);
        this.fok = true;
        this.foj = 6;
        this.fol = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.foc = R.drawable.icon_pure_post_more24_svg;
        this.fod = R.drawable.icon_mask_post_more24_selection_svg;
        this.fof = true;
        this.fnp = new MoreDeskView(context, !z);
        this.fok = true;
        this.foj = 6;
        this.fol = new int[]{1};
    }
}
