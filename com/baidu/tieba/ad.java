package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.view.BaseViewPager;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.a.i;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.a.f;
        if (currentItem != iArr.length) {
            baseViewPager2 = this.a.i;
            baseViewPager2.a(currentItem + 1, true);
        }
    }
}
