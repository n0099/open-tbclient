package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gqB = 1;
    private int[] dps;
    private ArrayList<PersonalGroupFragment> gqC;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gqC = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gqC.add(personalGroupFragment);
        if (z) {
            this.dps = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gqC.add(personalGroupFragment2);
            this.dps = new int[]{0, 1};
        }
        gqB = this.dps.length;
        Iterator<PersonalGroupFragment> it = this.gqC.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gqC.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gqB || i < 0) {
            return null;
        }
        return this.gqC.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gqB;
    }

    public int uj(int i) {
        return this.dps[i];
    }
}
