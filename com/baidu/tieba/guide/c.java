package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.view.RightSlideViewPager;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c implements com.baidu.tieba.model.q {
    final /* synthetic */ NewUserGuideActivity aMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.aMZ = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.model.q
    public void a(InterestFrsData interestFrsData) {
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        RightSlideViewPager rightSlideViewPager;
        oVar = this.aMZ.aMT;
        oVar.dt(false);
        oVar2 = this.aMZ.aMT;
        oVar2.e(interestFrsData);
        rightSlideViewPager = this.aMZ.aMX;
        ((m) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.model.q
    public void b(InterestFrsData interestFrsData) {
        com.baidu.tieba.model.o oVar;
        com.baidu.tieba.model.o oVar2;
        oVar = this.aMZ.aMT;
        oVar.dt(true);
        oVar2 = this.aMZ.aMT;
        oVar2.e(null);
        this.aMZ.showToast(z.neterror);
    }
}
