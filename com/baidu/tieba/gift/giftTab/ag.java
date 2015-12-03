package com.baidu.tieba.gift.giftTab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ ad bwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.bwb = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bwb.buo.getVisibility() != 0) {
            this.bwb.bvG.closeActivity();
        } else {
            this.bwb.buo.setVisibility(8);
        }
    }
}
