package com.baidu.tieba.flist;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class p extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1258a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumListActivity forumListActivity) {
        this.f1258a = forumListActivity;
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        boolean z;
        z = this.f1258a.s;
        return z ? 1 : 2;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                viewGroup.addView(this.f1258a.c.g);
                return this.f1258a.c.g;
            case 1:
                viewGroup.addView(this.f1258a.c.h);
                return this.f1258a.c.h;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
