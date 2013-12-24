package com.baidu.tieba.flist;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class p extends android.support.v4.view.ae {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        boolean z;
        z = this.a.s;
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
                viewGroup.addView(this.a.c.h);
                return this.a.c.h;
            case 1:
                viewGroup.addView(this.a.c.i);
                return this.a.c.i;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
