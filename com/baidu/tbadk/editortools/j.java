package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eNF = R.drawable.icon_pure_post_more24_svg;
        this.eNG = R.drawable.icon_mask_post_more24_selection_svg;
        this.eNI = true;
        this.eMS = new MoreDeskView(context);
        this.eNN = true;
        this.eNM = 6;
        this.eNO = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.name = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.eNF = R.drawable.icon_pure_post_more24_svg;
        this.eNG = R.drawable.icon_mask_post_more24_selection_svg;
        this.eNI = true;
        this.eMS = new MoreDeskView(context, !z);
        this.eNN = true;
        this.eNM = 6;
        this.eNO = new int[]{1};
    }
}
