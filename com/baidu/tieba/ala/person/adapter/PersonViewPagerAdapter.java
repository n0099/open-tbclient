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
    private List<Fragment> gTq;

    public PersonViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.gTq = new LinkedList();
    }

    public void setData(List<Fragment> list) {
        this.gTq.clear();
        if (!ListUtils.isEmpty(list)) {
            this.gTq.addAll(list);
        }
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.gTq.get(i);
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
        return this.gTq.size();
    }
}
