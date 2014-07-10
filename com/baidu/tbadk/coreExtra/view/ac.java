package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LiveBroadcastCard liveBroadcastCard) {
        this.a = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        agVar = this.a.b;
        if (agVar != null) {
            agVar2 = this.a.b;
            agVar2.a(view);
        }
    }
}
