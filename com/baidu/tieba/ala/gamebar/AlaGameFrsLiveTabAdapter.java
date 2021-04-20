package com.baidu.tieba.ala.gamebar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<Fragment> f14661a;

    public AlaGameFrsLiveTabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void c(List<Fragment> list) {
        this.f14661a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.f14661a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.f14661a.size() > i) {
            return this.f14661a.get(i);
        }
        return null;
    }
}
