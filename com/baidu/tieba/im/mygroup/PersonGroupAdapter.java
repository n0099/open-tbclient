package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int eOV = 1;
    private int[] bUW;
    private ArrayList<PersonalGroupFragment> eOW;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eOW = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.eOW.add(personalGroupFragment);
        if (z) {
            this.bUW = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.eOW.add(personalGroupFragment2);
            this.bUW = new int[]{0, 1};
        }
        eOV = this.bUW.length;
        Iterator<PersonalGroupFragment> it = this.eOW.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eOW.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eOV || i < 0) {
            return null;
        }
        return this.eOW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eOV;
    }

    public int pC(int i) {
        return this.bUW[i];
    }
}
