package com.baidu.tieba.gift.giftTab;

import android.view.View;
import com.baidu.tieba.gift.giftTab.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ ad bwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ad adVar) {
        this.bwb = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad.e eVar;
        ad.e eVar2;
        eVar = this.bwb.bvo;
        if (eVar != null) {
            eVar2 = this.bwb.bvo;
            eVar2.Tf();
        }
    }
}
