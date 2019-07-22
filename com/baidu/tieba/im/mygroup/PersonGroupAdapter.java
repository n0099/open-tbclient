package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gOc = 1;
    private int[] dDt;
    private ArrayList<PersonalGroupFragment> gOd;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gOd = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gOd.add(personalGroupFragment);
        if (z) {
            this.dDt = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gOd.add(personalGroupFragment2);
            this.dDt = new int[]{0, 1};
        }
        gOc = this.dDt.length;
        Iterator<PersonalGroupFragment> it = this.gOd.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gOd.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gOc || i < 0) {
            return null;
        }
        return this.gOd.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gOc;
    }

    public int vR(int i) {
        return this.dDt[i];
    }
}
