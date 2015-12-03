package com.baidu.tieba.gift.giftTab;

import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ ah bwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bwc = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad adVar;
        ad adVar2;
        int i;
        ad adVar3;
        ad adVar4;
        int i2;
        ad adVar5;
        int i3;
        ad adVar6;
        int i4;
        ad adVar7;
        ad adVar8;
        adVar = this.bwc.bwb;
        adVar.cR(false);
        adVar2 = this.bwc.bwb;
        i = adVar2.bvV;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
        int[] iArr = new int[2];
        adVar3 = this.bwc.bwb;
        adVar3.bug.getLocationOnScreen(iArr);
        int i5 = iArr[0];
        adVar4 = this.bwc.bwb;
        i2 = adVar4.bvW;
        layoutParams.leftMargin = i5 - i2;
        int i6 = iArr[1];
        adVar5 = this.bwc.bwb;
        i3 = adVar5.bvU;
        int i7 = i6 - i3;
        adVar6 = this.bwc.bwb;
        i4 = adVar6.bvW;
        layoutParams.topMargin = i7 - i4;
        adVar7 = this.bwc.bwb;
        adVar7.bup.setLayoutParams(layoutParams);
        adVar8 = this.bwc.bwb;
        adVar8.buo.setVisibility(0);
    }
}
