package com.baidu.tieba.ala.gamefrslivelist;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveListAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<Fragment> f14079a;

    public AlaGameFrsLiveListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void b(List<Fragment> list) {
        this.f14079a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.f14079a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (this.f14079a.size() > i2) {
            return this.f14079a.get(i2);
        }
        return null;
    }
}
