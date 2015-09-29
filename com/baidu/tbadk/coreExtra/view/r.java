package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard akI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LiveBroadcastCard liveBroadcastCard) {
        this.akI = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.d dVar;
        LiveBroadcastCard.d dVar2;
        dVar = this.akI.mDeleteListener;
        if (dVar != null) {
            dVar2 = this.akI.mDeleteListener;
            dVar2.onDeleteClick(view);
        }
    }
}
