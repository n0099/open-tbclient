package com.baidu.tieba.flist;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class o extends PagerAdapter {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        boolean z;
        z = this.a.s;
        return z ? 1 : 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                viewGroup.addView(this.a.c.i);
                return this.a.c.i;
            case 1:
                viewGroup.addView(this.a.c.j);
                return this.a.c.j;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
