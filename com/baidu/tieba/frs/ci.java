package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ci implements View.OnClickListener {
    private final /* synthetic */ MetaData bje;
    private final /* synthetic */ View.OnClickListener bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(MetaData metaData, View.OnClickListener onClickListener) {
        this.bje = metaData;
        this.bjf = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10632").ac("obj_id", this.bje.getUserId()));
        this.bjf.onClick(view);
    }
}
