package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ao;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
class c implements aq {
    final /* synthetic */ NewUserGuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.a = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.model.aq
    public void a(InterestFrsData interestFrsData) {
        ao aoVar;
        ao aoVar2;
        RightSlideViewPager rightSlideViewPager;
        aoVar = this.a.c;
        aoVar.a(false);
        aoVar2 = this.a.c;
        aoVar2.a(interestFrsData);
        rightSlideViewPager = this.a.h;
        ((p) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).a(interestFrsData);
    }

    @Override // com.baidu.tieba.model.aq
    public void b(InterestFrsData interestFrsData) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.a.c;
        aoVar.a(true);
        aoVar2 = this.a.c;
        aoVar2.a((InterestFrsData) null);
        this.a.c(com.baidu.tieba.u.neterror_interestfrs);
    }
}
