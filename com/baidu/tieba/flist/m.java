package com.baidu.tieba.flist;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class m extends PagerAdapter {
    final /* synthetic */ ForumListActivity avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        boolean z;
        z = this.avY.avB;
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
                viewGroup.addView(this.avY.avH.aww);
                return this.avY.avH.aww;
            case 1:
                viewGroup.addView(this.avY.avH.awx);
                return this.avY.avH.awx;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
