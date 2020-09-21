package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes25.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int jFN = 1;
    private int[] gcg;
    private ArrayList<PersonalGroupFragment> jFO;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.jFO = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.jFO.add(personalGroupFragment);
        if (z) {
            this.gcg = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.jFO.add(personalGroupFragment2);
            this.gcg = new int[]{0, 1};
        }
        jFN = this.gcg.length;
        Iterator<PersonalGroupFragment> it = this.jFO.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.jFO.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= jFN || i < 0) {
            return null;
        }
        return this.jFO.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return jFN;
    }

    public int Cg(int i) {
        return this.gcg[i];
    }
}
