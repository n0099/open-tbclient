package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ MetaData bUm;
    private final /* synthetic */ View.OnClickListener bUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MetaData metaData, View.OnClickListener onClickListener) {
        this.bUm = metaData;
        this.bUn = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new ar("c10632").ab("obj_id", this.bUm.getUserId()));
        this.bUn.onClick(view);
    }
}
