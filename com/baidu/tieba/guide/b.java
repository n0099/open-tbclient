package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.bh;
import com.baidu.tieba.model.bj;
import com.baidu.tieba.view.RightSlideViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements bj {
    final /* synthetic */ NewUserGuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewUserGuideActivity newUserGuideActivity) {
        this.a = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.model.bj
    public void a(InterestFrsData interestFrsData) {
        bh bhVar;
        bh bhVar2;
        RightSlideViewPager rightSlideViewPager;
        bhVar = this.a.d;
        bhVar.a(false);
        bhVar2 = this.a.d;
        bhVar2.a(interestFrsData);
        rightSlideViewPager = this.a.i;
        ((o) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).a(interestFrsData);
    }

    @Override // com.baidu.tieba.model.bj
    public void b(InterestFrsData interestFrsData) {
        bh bhVar;
        bh bhVar2;
        bhVar = this.a.d;
        bhVar.a(true);
        bhVar2 = this.a.d;
        bhVar2.a((InterestFrsData) null);
        this.a.c(R.string.neterror_interestfrs);
    }
}
