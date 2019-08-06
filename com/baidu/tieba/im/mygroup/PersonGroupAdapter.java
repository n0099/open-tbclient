package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gOU = 1;
    private int[] dDA;
    private ArrayList<PersonalGroupFragment> gOV;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gOV = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gOV.add(personalGroupFragment);
        if (z) {
            this.dDA = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gOV.add(personalGroupFragment2);
            this.dDA = new int[]{0, 1};
        }
        gOU = this.dDA.length;
        Iterator<PersonalGroupFragment> it = this.gOV.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gOV.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gOU || i < 0) {
            return null;
        }
        return this.gOV.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gOU;
    }

    public int vT(int i) {
        return this.dDA[i];
    }
}
