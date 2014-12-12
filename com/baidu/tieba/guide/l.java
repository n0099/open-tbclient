package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j aNu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aNu = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.aNu.aNp;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.aNu.aNp;
            if (newUserGuideActivity2.IQ().Uo()) {
                newUserGuideActivity4 = this.aNu.aNp;
                newUserGuideActivity4.IS();
                return;
            }
            newUserGuideActivity3 = this.aNu.aNp;
            RightSlideViewPager IP = newUserGuideActivity3.IP();
            if (IP != null) {
                IP.setCurrentItem(1, true);
            }
        }
    }
}
