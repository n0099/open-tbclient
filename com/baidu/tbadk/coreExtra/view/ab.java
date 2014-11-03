package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard OD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LiveBroadcastCard liveBroadcastCard) {
        this.OD = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        af afVar2;
        afVar = this.OD.mDeleteListener;
        if (afVar != null) {
            afVar2 = this.OD.mDeleteListener;
            afVar2.p(view);
        }
    }
}
