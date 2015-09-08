package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard amf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(LiveBroadcastCard liveBroadcastCard) {
        this.amf = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.d dVar;
        LiveBroadcastCard.d dVar2;
        dVar = this.amf.mDeleteListener;
        if (dVar != null) {
            dVar2 = this.amf.mDeleteListener;
            dVar2.onDeleteClick(view);
        }
    }
}
