package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int hHS = 1;
    private int[] eDx;
    private ArrayList<PersonalGroupFragment> hHT;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.hHT = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.hHT.add(personalGroupFragment);
        if (z) {
            this.eDx = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.hHT.add(personalGroupFragment2);
            this.eDx = new int[]{0, 1};
        }
        hHS = this.eDx.length;
        Iterator<PersonalGroupFragment> it = this.hHT.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.hHT.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= hHS || i < 0) {
            return null;
        }
        return this.hHT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return hHS;
    }

    public int wP(int i) {
        return this.eDx[i];
    }
}
