package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard UW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LiveBroadcastCard liveBroadcastCard) {
        this.UW = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        ah ahVar2;
        ahVar = this.UW.mDeleteListener;
        if (ahVar != null) {
            ahVar2 = this.UW.mDeleteListener;
            ahVar2.onDeleteClick(view);
        }
    }
}
