package com.baidu.tieba.flist;

import android.support.v4.view.ae;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class j extends ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumListActivity forumListActivity) {
        this.f821a = forumListActivity;
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                viewGroup.addView(this.f821a.f811a.j);
                return this.f821a.f811a.j;
            case 1:
                viewGroup.addView(this.f821a.f811a.k);
                return this.f821a.f811a.k;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
