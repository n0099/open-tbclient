package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i extends l {
    public i(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eut = R.drawable.icon_pure_post_more24_svg;
        this.euu = R.drawable.icon_mask_post_more24_selection_svg;
        this.euw = true;
        this.etH = new MoreDeskView(context);
        this.euA = true;
        this.euz = 6;
        this.euB = new int[]{1};
    }

    public i(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eut = R.drawable.icon_pure_post_more24_svg;
        this.euu = R.drawable.icon_mask_post_more24_selection_svg;
        this.euw = true;
        this.etH = new MoreDeskView(context, !z);
        this.euA = true;
        this.euz = 6;
        this.euB = new int[]{1};
    }
}
