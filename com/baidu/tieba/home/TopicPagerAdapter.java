package com.baidu.tieba.home;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TopicPagerAdapter extends android.support.v4.view.ae implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<View> f1325a;
    private View b;

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f1325a.get(i));
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f1325a.get(i));
        return this.f1325a.get(i);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f1325a.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag;
        if (this.b != null && (findViewWithTag = this.b.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
