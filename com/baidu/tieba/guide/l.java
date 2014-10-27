package com.baidu.tieba.guide;

import android.view.View;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j aLn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aLn = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.aLn.aLi;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.aLn.aLi;
            if (newUserGuideActivity2.Iv().TO()) {
                newUserGuideActivity4 = this.aLn.aLi;
                newUserGuideActivity4.Ix();
                return;
            }
            newUserGuideActivity3 = this.aLn.aLi;
            RightSlideViewPager Iu = newUserGuideActivity3.Iu();
            if (Iu != null) {
                Iu.setCurrentItem(1, true);
            }
        }
    }
}
