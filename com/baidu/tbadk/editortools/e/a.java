package com.baidu.tbadk.editortools.e;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.pb_vote_text), 32, i);
        this.fCb = R.drawable.ic_icon_pure_more_vote60_svg;
        this.fCd = R.drawable.icon_pure_post_more_vote64;
        this.fCe = false;
        this.fCg = true;
        this.fCk = new int[]{22};
    }
}
