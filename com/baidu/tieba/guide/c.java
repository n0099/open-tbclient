package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ao;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.view.RightSlideViewPager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements aq {
    final /* synthetic */ NewUserGuideActivity aLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.aLf = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.model.aq
    public void a(InterestFrsData interestFrsData) {
        ao aoVar;
        ao aoVar2;
        RightSlideViewPager rightSlideViewPager;
        aoVar = this.aLf.aKZ;
        aoVar.dH(false);
        aoVar2 = this.aLf.aKZ;
        aoVar2.e(interestFrsData);
        rightSlideViewPager = this.aLf.aLd;
        ((m) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).c(interestFrsData);
    }

    @Override // com.baidu.tieba.model.aq
    public void b(InterestFrsData interestFrsData) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.aLf.aKZ;
        aoVar.dH(true);
        aoVar2 = this.aLf.aKZ;
        aoVar2.e(null);
        this.aLf.showToast(y.neterror);
    }
}
