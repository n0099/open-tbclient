package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gNY = 1;
    private int[] dJB;
    private ArrayList<PersonalGroupFragment> gNZ;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gNZ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gNZ.add(personalGroupFragment);
        if (z) {
            this.dJB = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gNZ.add(personalGroupFragment2);
            this.dJB = new int[]{0, 1};
        }
        gNY = this.dJB.length;
        Iterator<PersonalGroupFragment> it = this.gNZ.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gNZ.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gNY || i < 0) {
            return null;
        }
        return this.gNZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gNY;
    }

    public int uC(int i) {
        return this.dJB[i];
    }
}
