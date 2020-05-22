package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int iHU = 1;
    private int[] fwa;
    private ArrayList<PersonalGroupFragment> iHV;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.iHV = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.iHV.add(personalGroupFragment);
        if (z) {
            this.fwa = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.iHV.add(personalGroupFragment2);
            this.fwa = new int[]{0, 1};
        }
        iHU = this.fwa.length;
        Iterator<PersonalGroupFragment> it = this.iHV.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.iHV.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= iHU || i < 0) {
            return null;
        }
        return this.iHV.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return iHU;
    }

    public int yb(int i) {
        return this.fwa[i];
    }
}
