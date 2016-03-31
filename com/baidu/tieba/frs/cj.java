package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class cj implements View.OnClickListener {
    private final /* synthetic */ MetaData bnB;
    private final /* synthetic */ View.OnClickListener bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(MetaData metaData, View.OnClickListener onClickListener) {
        this.bnB = metaData;
        this.bnC = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10632").ac("obj_id", this.bnB.getUserId()));
        this.bnC.onClick(view);
    }
}
