package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ MetaData cby;
    private final /* synthetic */ View.OnClickListener cbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MetaData metaData, View.OnClickListener onClickListener) {
        this.cby = metaData;
        this.cbz = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new as("c10632").Z("obj_id", this.cby.getUserId()));
        this.cbz.onClick(view);
    }
}
