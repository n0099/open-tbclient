package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard agj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LiveBroadcastCard liveBroadcastCard) {
        this.agj = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        ah ahVar2;
        ahVar = this.agj.mDeleteListener;
        if (ahVar != null) {
            ahVar2 = this.agj.mDeleteListener;
            ahVar2.onDeleteClick(view);
        }
    }
}
