package com.baidu.tieba.ala.person.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> gDf;

    public PersonViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.gDf = new LinkedList();
    }

    public void setData(List<Fragment> list) {
        this.gDf.clear();
        if (!ListUtils.isEmpty(list)) {
            this.gDf.addAll(list);
        }
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.gDf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return "";
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gDf.size();
    }
}
