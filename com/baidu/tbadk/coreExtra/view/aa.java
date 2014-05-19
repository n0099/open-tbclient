package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LiveBroadcastCard liveBroadcastCard) {
        this.a = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.a.b;
        if (aeVar != null) {
            aeVar2 = this.a.b;
            aeVar2.a(view);
        }
    }
}
