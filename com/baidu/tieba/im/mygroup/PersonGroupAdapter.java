package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int egZ = 1;
    private int[] bvQ;
    private ArrayList<PersonalGroupFragment> eha;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eha = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.eha.add(personalGroupFragment);
        if (z) {
            this.bvQ = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.eha.add(personalGroupFragment2);
            this.bvQ = new int[]{0, 1};
        }
        egZ = this.bvQ.length;
        Iterator<PersonalGroupFragment> it = this.eha.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eha.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= egZ || i < 0) {
            return null;
        }
        return this.eha.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return egZ;
    }

    public int nT(int i) {
        return this.bvQ[i];
    }
}
