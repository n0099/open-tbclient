package com.baidu.tieba;

import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aa implements com.baidu.tieba.view.e {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // com.baidu.tieba.view.e
    public void a(int i) {
        BaseViewPager baseViewPager;
        BaseViewPager baseViewPager2;
        if (i == 0) {
            baseViewPager = this.a.i;
            if (baseViewPager != null) {
                baseViewPager2 = this.a.i;
                baseViewPager2.setOnScrollOutListener(null);
            }
            this.a.a();
            CompatibleUtile.setAnim(this.a, 0, R.anim.left);
        }
    }
}
