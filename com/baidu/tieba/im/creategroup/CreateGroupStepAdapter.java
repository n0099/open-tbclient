package com.baidu.tieba.im.creategroup;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepAdapter extends ae {

    /* renamed from: a  reason: collision with root package name */
    public CreateGroupStepActivity f1615a;
    private List<v> b = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.f1615a = createGroupStepActivity;
    }

    public List<v> a() {
        return this.b;
    }

    public v a(int i) {
        return this.b.get(i);
    }

    public void a(v vVar) {
        this.b.add(vVar);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.b.get(i).a(), 0);
        return this.b.get(i).a();
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.b.get(i).a());
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
