package com.baidu.tieba.forumdetail;

import android.support.v4.view.bq;
/* loaded from: classes.dex */
class m implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemHotThreadView f1094a;

    private m(ItemHotThreadView itemHotThreadView) {
        this.f1094a = itemHotThreadView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(ItemHotThreadView itemHotThreadView, m mVar) {
        this(itemHotThreadView);
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        if (ItemHotThreadView.a(this.f1094a) != null) {
            ItemHotThreadView.a(this.f1094a).setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }
}
