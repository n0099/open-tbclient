package com.baidu.tbadk.editortools.e;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends l {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.pb_vote_text), 32, i);
        this.eAM = R.drawable.ic_icon_pure_more_vote60_svg;
        this.eAP = true;
        this.eAQ = true;
        this.eAU = new int[]{22};
    }
}
