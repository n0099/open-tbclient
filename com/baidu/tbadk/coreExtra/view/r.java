package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard amz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LiveBroadcastCard liveBroadcastCard) {
        this.amz = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.d dVar;
        LiveBroadcastCard.d dVar2;
        dVar = this.amz.mDeleteListener;
        if (dVar != null) {
            dVar2 = this.amz.mDeleteListener;
            dVar2.onDeleteClick(view);
        }
    }
}
