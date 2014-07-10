package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.an;
import com.baidu.tieba.model.ap;
import com.baidu.tieba.view.RightSlideViewPager;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements ap {
    final /* synthetic */ NewUserGuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.a = newUserGuideActivity;
    }

    @Override // com.baidu.tieba.model.ap
    public void a(InterestFrsData interestFrsData) {
        an anVar;
        an anVar2;
        RightSlideViewPager rightSlideViewPager;
        anVar = this.a.c;
        anVar.a(false);
        anVar2 = this.a.c;
        anVar2.a(interestFrsData);
        rightSlideViewPager = this.a.h;
        ((m) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(1)).a(interestFrsData);
    }

    @Override // com.baidu.tieba.model.ap
    public void b(InterestFrsData interestFrsData) {
        an anVar;
        an anVar2;
        anVar = this.a.c;
        anVar.a(true);
        anVar2 = this.a.c;
        anVar2.a((InterestFrsData) null);
        this.a.c(y.neterror);
    }
}
