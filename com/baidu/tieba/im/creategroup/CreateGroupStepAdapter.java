package com.baidu.tieba.im.creategroup;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepAdapter extends ae {

    /* renamed from: a  reason: collision with root package name */
    public CreateGroupStepActivity f1488a;
    private List<q> b = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.f1488a = createGroupStepActivity;
    }

    public List<q> a() {
        return this.b;
    }

    public q a(int i) {
        return this.b.get(i);
    }

    public void a(q qVar) {
        this.b.add(qVar);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.b.get(i).f(), 0);
        return this.b.get(i).f();
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.b.get(i).f());
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
