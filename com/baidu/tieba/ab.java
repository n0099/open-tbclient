package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GuideActivity guideActivity) {
        this.f1028a = guideActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.f1028a.i;
            if (baseViewPager != null) {
                baseViewPager2 = this.f1028a.i;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.f1028a.a();
            CompatibleUtile.setAnim(this.f1028a, 0, R.anim.left);
        }
    }
}
