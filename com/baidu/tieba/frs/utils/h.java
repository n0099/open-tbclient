package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ MetaData ciR;
    private final /* synthetic */ View.OnClickListener ciS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MetaData metaData, View.OnClickListener onClickListener) {
        this.ciR = metaData;
        this.ciS = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new av("c10632").ab("obj_id", this.ciR.getUserId()));
        this.ciS.onClick(view);
    }
}
