package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eLk = R.drawable.icon_pure_post_more24_svg;
        this.eLl = R.drawable.icon_mask_post_more24_selection_svg;
        this.eLn = true;
        this.eKx = new MoreDeskView(context);
        this.eLs = true;
        this.eLr = 6;
        this.eLt = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eLk = R.drawable.icon_pure_post_more24_svg;
        this.eLl = R.drawable.icon_mask_post_more24_selection_svg;
        this.eLn = true;
        this.eKx = new MoreDeskView(context, !z);
        this.eLs = true;
        this.eLr = 6;
        this.eLt = new int[]{1};
    }
}
