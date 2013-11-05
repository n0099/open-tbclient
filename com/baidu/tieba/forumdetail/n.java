package com.baidu.tieba.forumdetail;

import android.support.v4.view.bq;
/* loaded from: classes.dex */
class n implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemHotThreadView f1226a;

    private n(ItemHotThreadView itemHotThreadView) {
        this.f1226a = itemHotThreadView;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        if (ItemHotThreadView.a(this.f1226a) != null) {
            ItemHotThreadView.a(this.f1226a).setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }
}
