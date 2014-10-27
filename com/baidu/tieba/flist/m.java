package com.baidu.tieba.flist;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class m extends PagerAdapter {
    final /* synthetic */ ForumListActivity avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        boolean z;
        z = this.avP.avs;
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
                viewGroup.addView(this.avP.avy.awn);
                return this.avP.avy.awn;
            case 1:
                viewGroup.addView(this.avP.avy.awo);
                return this.avP.avy.awo;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
