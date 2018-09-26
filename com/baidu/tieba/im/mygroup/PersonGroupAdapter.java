package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int eHm = 1;
    private int[] bMu;
    private ArrayList<PersonalGroupFragment> eHn;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eHn = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.eHn.add(personalGroupFragment);
        if (z) {
            this.bMu = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.eHn.add(personalGroupFragment2);
            this.bMu = new int[]{0, 1};
        }
        eHm = this.bMu.length;
        Iterator<PersonalGroupFragment> it = this.eHn.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eHn.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eHm || i < 0) {
            return null;
        }
        return this.eHn.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eHm;
    }

    public int pe(int i) {
        return this.bMu[i];
    }
}
