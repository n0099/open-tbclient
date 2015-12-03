package com.baidu.tieba.gift.giftTab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ ad bwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ad adVar) {
        this.bwb = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bwb.buo.setVisibility(8);
        com.baidu.adp.lib.util.k.c(this.bwb.bvG.getPageContext().getPageActivity(), this.bwb.bug);
    }
}
