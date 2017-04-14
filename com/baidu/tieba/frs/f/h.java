package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ MetaData bZZ;
    private final /* synthetic */ View.OnClickListener caa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MetaData metaData, View.OnClickListener onClickListener) {
        this.bZZ = metaData;
        this.caa = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new as("c10632").aa("obj_id", this.bZZ.getUserId()));
        this.caa.onClick(view);
    }
}
