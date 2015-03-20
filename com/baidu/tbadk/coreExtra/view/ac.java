package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard afa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LiveBroadcastCard liveBroadcastCard) {
        this.afa = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        agVar = this.afa.mDeleteListener;
        if (agVar != null) {
            agVar2 = this.afa.mDeleteListener;
            agVar2.onDeleteClick(view);
        }
    }
}
