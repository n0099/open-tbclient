package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fij = R.drawable.icon_pure_post_more24_svg;
        this.fik = R.drawable.icon_mask_post_more24_selection_svg;
        this.fim = true;
        this.fhv = new MoreDeskView(context);
        this.fis = true;
        this.fir = 6;
        this.fit = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.fij = R.drawable.icon_pure_post_more24_svg;
        this.fik = R.drawable.icon_mask_post_more24_selection_svg;
        this.fim = true;
        this.fhv = new MoreDeskView(context, !z);
        this.fis = true;
        this.fir = 6;
        this.fit = new int[]{1};
    }
}
