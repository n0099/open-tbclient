package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard akO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LiveBroadcastCard liveBroadcastCard) {
        this.akO = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.d dVar;
        LiveBroadcastCard.d dVar2;
        dVar = this.akO.mDeleteListener;
        if (dVar != null) {
            dVar2 = this.akO.mDeleteListener;
            dVar2.onDeleteClick(view);
        }
    }
}
