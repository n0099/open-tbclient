package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class bi implements View.OnClickListener {
    private final /* synthetic */ MetaData bQV;
    private final /* synthetic */ View.OnClickListener bQW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(MetaData metaData, View.OnClickListener onClickListener) {
        this.bQV = metaData;
        this.bQW = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10632").ab("obj_id", this.bQV.getUserId()));
        this.bQW.onClick(view);
    }
}
