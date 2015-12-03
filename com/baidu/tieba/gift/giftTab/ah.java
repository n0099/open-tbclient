package com.baidu.tieba.gift.giftTab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ad bwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ad adVar) {
        this.bwb = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.k.c(this.bwb.bvG.getPageContext().getPageActivity(), this.bwb.bug);
        this.bwb.bvG.mHandler.postDelayed(new ai(this), 200L);
    }
}
