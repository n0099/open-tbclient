package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.view.BaseViewPager;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(GuideActivity guideActivity) {
        this.f1111a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseViewPager baseViewPager;
        int[] iArr;
        BaseViewPager baseViewPager2;
        baseViewPager = this.f1111a.i;
        int currentItem = baseViewPager.getCurrentItem();
        iArr = this.f1111a.f;
        if (currentItem != iArr.length) {
            baseViewPager2 = this.f1111a.i;
            baseViewPager2.a(currentItem + 1, true);
        }
    }
}
