package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bgh;
    private final /* synthetic */ View.OnClickListener bgi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(com.baidu.tbadk.core.data.z zVar, View.OnClickListener onClickListener) {
        this.bgh = zVar;
        this.bgi = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10632").aa("obj_id", this.bgh.getAuthor().getUserId()));
        if (this.bgi != null) {
            this.bgi.onClick(view);
        }
    }
}
