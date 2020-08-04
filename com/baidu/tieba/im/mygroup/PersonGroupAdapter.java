package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int jig = 1;
    private int[] fMQ;
    private ArrayList<PersonalGroupFragment> jih;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.jih = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.jih.add(personalGroupFragment);
        if (z) {
            this.fMQ = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.jih.add(personalGroupFragment2);
            this.fMQ = new int[]{0, 1};
        }
        jig = this.fMQ.length;
        Iterator<PersonalGroupFragment> it = this.jih.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.jih.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= jig || i < 0) {
            return null;
        }
        return this.jih.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return jig;
    }

    public int zm(int i) {
        return this.fMQ[i];
    }
}
