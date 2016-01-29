package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ch implements View.OnClickListener {
    private final /* synthetic */ MetaData biQ;
    private final /* synthetic */ View.OnClickListener biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(MetaData metaData, View.OnClickListener onClickListener) {
        this.biQ = metaData;
        this.biR = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10632").aa("obj_id", this.biQ.getUserId()));
        if (this.biR != null) {
            this.biR.onClick(view);
        }
    }
}
