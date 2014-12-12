package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard Up;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LiveBroadcastCard liveBroadcastCard) {
        this.Up = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        ah ahVar2;
        ahVar = this.Up.mDeleteListener;
        if (ahVar != null) {
            ahVar2 = this.Up.mDeleteListener;
            ahVar2.onDeleteClick(view);
        }
    }
}
