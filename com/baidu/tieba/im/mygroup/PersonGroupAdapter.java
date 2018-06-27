package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int ewg = 1;
    private int[] bFQ;
    private ArrayList<PersonalGroupFragment> ewh;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.ewh = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.ewh.add(personalGroupFragment);
        if (z) {
            this.bFQ = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.ewh.add(personalGroupFragment2);
            this.bFQ = new int[]{0, 1};
        }
        ewg = this.bFQ.length;
        Iterator<PersonalGroupFragment> it = this.ewh.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.ewh.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= ewg || i < 0) {
            return null;
        }
        return this.ewh.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ewg;
    }

    public int om(int i) {
        return this.bFQ[i];
    }
}
