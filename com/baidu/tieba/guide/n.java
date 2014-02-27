package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.a.c;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.a.c;
            if (newUserGuideActivity2.h().a()) {
                newUserGuideActivity4 = this.a.c;
                newUserGuideActivity4.i();
                return;
            }
            newUserGuideActivity3 = this.a.c;
            RightSlideViewPager f = newUserGuideActivity3.f();
            if (f != null) {
                f.setCurrentItem(1, true);
            }
        }
    }
}
