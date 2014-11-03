package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j aLB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aLB = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.aLB.aLw;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.aLB.aLw;
            if (newUserGuideActivity2.Iz().TR()) {
                newUserGuideActivity4 = this.aLB.aLw;
                newUserGuideActivity4.IB();
                return;
            }
            newUserGuideActivity3 = this.aLB.aLw;
            RightSlideViewPager Iy = newUserGuideActivity3.Iy();
            if (Iy != null) {
                Iy.setCurrentItem(1, true);
            }
        }
    }
}
