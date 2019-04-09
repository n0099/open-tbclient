package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gqC = 1;
    private int[] dpt;
    private ArrayList<PersonalGroupFragment> gqD;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gqD = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gqD.add(personalGroupFragment);
        if (z) {
            this.dpt = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gqD.add(personalGroupFragment2);
            this.dpt = new int[]{0, 1};
        }
        gqC = this.dpt.length;
        Iterator<PersonalGroupFragment> it = this.gqD.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gqD.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gqC || i < 0) {
            return null;
        }
        return this.gqD.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gqC;
    }

    public int uj(int i) {
        return this.dpt[i];
    }
}
