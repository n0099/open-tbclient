package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int hHE = 1;
    private int[] eDj;
    private ArrayList<PersonalGroupFragment> hHF;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.hHF = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.hHF.add(personalGroupFragment);
        if (z) {
            this.eDj = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.hHF.add(personalGroupFragment2);
            this.eDj = new int[]{0, 1};
        }
        hHE = this.eDj.length;
        Iterator<PersonalGroupFragment> it = this.hHF.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.hHF.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= hHE || i < 0) {
            return null;
        }
        return this.hHF.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return hHE;
    }

    public int wP(int i) {
        return this.eDj[i];
    }
}
