package com.baidu.tieba.frs.d;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    private final /* synthetic */ MetaData cag;
    private final /* synthetic */ View.OnClickListener cah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MetaData metaData, View.OnClickListener onClickListener) {
        this.cag = metaData;
        this.cah = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new as("c10632").aa("obj_id", this.cag.getUserId()));
        this.cah.onClick(view);
    }
}
