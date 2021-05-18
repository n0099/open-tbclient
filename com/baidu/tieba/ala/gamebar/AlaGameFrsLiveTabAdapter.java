package com.baidu.tieba.ala.gamebar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<Fragment> f14062a;

    public AlaGameFrsLiveTabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void b(List<Fragment> list) {
        this.f14062a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.f14062a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (this.f14062a.size() > i2) {
            return this.f14062a.get(i2);
        }
        return null;
    }
}
