package com.baidu.tieba.gift.giftTab;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Animation.AnimationListener {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ad adVar;
        z zVar;
        String str;
        long j;
        z zVar2;
        String str2;
        ad adVar2;
        adVar = this.bvt.bvf;
        adVar.buf.setVisibility(0);
        zVar = this.bvt.bvg;
        str = this.bvt.mFrom;
        j = this.bvt.mToUserId;
        zVar.j(str, j);
        zVar2 = this.bvt.bvg;
        str2 = this.bvt.mFrom;
        zVar2.hJ(str2);
        adVar2 = this.bvt.bvf;
        adVar2.Tl();
    }
}
