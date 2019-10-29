package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gOP = 1;
    private int[] dKs;
    private ArrayList<PersonalGroupFragment> gOQ;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gOQ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gOQ.add(personalGroupFragment);
        if (z) {
            this.dKs = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gOQ.add(personalGroupFragment2);
            this.dKs = new int[]{0, 1};
        }
        gOP = this.dKs.length;
        Iterator<PersonalGroupFragment> it = this.gOQ.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gOQ.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gOP || i < 0) {
            return null;
        }
        return this.gOQ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gOP;
    }

    public int uD(int i) {
        return this.dKs[i];
    }
}
