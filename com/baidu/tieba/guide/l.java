package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.a.d;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.a.d;
            if (newUserGuideActivity2.i().a()) {
                newUserGuideActivity4 = this.a.d;
                newUserGuideActivity4.j();
                return;
            }
            newUserGuideActivity3 = this.a.d;
            RightSlideViewPager h = newUserGuideActivity3.h();
            if (h != null) {
                h.setCurrentItem(1, true);
            }
        }
    }
}
