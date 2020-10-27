package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int khk = 1;
    private int[] gyC;
    private ArrayList<PersonalGroupFragment> khl;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.khl = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.khl.add(personalGroupFragment);
        if (z) {
            this.gyC = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.khl.add(personalGroupFragment2);
            this.gyC = new int[]{0, 1};
        }
        khk = this.gyC.length;
        Iterator<PersonalGroupFragment> it = this.khl.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.khl.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= khk || i < 0) {
            return null;
        }
        return this.khl.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return khk;
    }

    public int Df(int i) {
        return this.gyC[i];
    }
}
