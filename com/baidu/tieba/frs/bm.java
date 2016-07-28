package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    private final /* synthetic */ MetaData bFU;
    private final /* synthetic */ View.OnClickListener bFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MetaData metaData, View.OnClickListener onClickListener) {
        this.bFU = metaData;
        this.bFV = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10632").ab("obj_id", this.bFU.getUserId()));
        this.bFV.onClick(view);
    }
}
