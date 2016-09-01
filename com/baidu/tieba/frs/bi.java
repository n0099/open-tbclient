package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    private final /* synthetic */ MetaData bRc;
    private final /* synthetic */ View.OnClickListener bRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MetaData metaData, View.OnClickListener onClickListener) {
        this.bRc = metaData;
        this.bRd = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10632").ab("obj_id", this.bRc.getUserId()));
        this.bRd.onClick(view);
    }
}
