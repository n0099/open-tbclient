package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    private final /* synthetic */ MetaData bEH;
    private final /* synthetic */ View.OnClickListener bEI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MetaData metaData, View.OnClickListener onClickListener) {
        this.bEH = metaData;
        this.bEI = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10632").ab("obj_id", this.bEH.getUserId()));
        this.bEI.onClick(view);
    }
}
