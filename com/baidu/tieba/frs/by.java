package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bci;
    private final /* synthetic */ View.OnClickListener bcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(com.baidu.tbadk.core.data.z zVar, View.OnClickListener onClickListener) {
        this.bci = zVar;
        this.bcj = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10632").ab("obj_id", this.bci.getAuthor().getUserId()));
        if (this.bcj != null) {
            this.bcj.onClick(view);
        }
    }
}
