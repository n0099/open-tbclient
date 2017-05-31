package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    private final /* synthetic */ MetaData cgs;
    private final /* synthetic */ View.OnClickListener cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MetaData metaData, View.OnClickListener onClickListener) {
        this.cgs = metaData;
        this.cgt = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new as("c10632").Z("obj_id", this.cgs.getUserId()));
        this.cgt.onClick(view);
    }
}
