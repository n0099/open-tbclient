package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eLo = R.drawable.icon_pure_post_more24_svg;
        this.eLp = R.drawable.icon_mask_post_more24_selection_svg;
        this.eLr = true;
        this.eKB = new MoreDeskView(context);
        this.eLw = true;
        this.eLv = 6;
        this.eLx = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eLo = R.drawable.icon_pure_post_more24_svg;
        this.eLp = R.drawable.icon_mask_post_more24_selection_svg;
        this.eLr = true;
        this.eKB = new MoreDeskView(context, !z);
        this.eLw = true;
        this.eLv = 6;
        this.eLx = new int[]{1};
    }
}
