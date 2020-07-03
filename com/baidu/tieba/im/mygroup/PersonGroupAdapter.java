package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int iZK = 1;
    private int[] fHv;
    private ArrayList<PersonalGroupFragment> iZL;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.iZL = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.iZL.add(personalGroupFragment);
        if (z) {
            this.fHv = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.iZL.add(personalGroupFragment2);
            this.fHv = new int[]{0, 1};
        }
        iZK = this.fHv.length;
        Iterator<PersonalGroupFragment> it = this.iZL.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.iZL.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= iZK || i < 0) {
            return null;
        }
        return this.iZL.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return iZK;
    }

    public int yN(int i) {
        return this.fHv[i];
    }
}
