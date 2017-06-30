package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    private final /* synthetic */ MetaData coI;
    private final /* synthetic */ View.OnClickListener coJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MetaData metaData, View.OnClickListener onClickListener) {
        this.coI = metaData;
        this.coJ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new au("c10632").Z("obj_id", this.coI.getUserId()));
        this.coJ.onClick(view);
    }
}
