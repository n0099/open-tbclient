package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ MetaData bNY;
    private final /* synthetic */ View.OnClickListener bNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MetaData metaData, View.OnClickListener onClickListener) {
        this.bNY = metaData;
        this.bNZ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new at("c10632").ab("obj_id", this.bNY.getUserId()));
        this.bNZ.onClick(view);
    }
}
