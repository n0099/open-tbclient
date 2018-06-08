package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int esp = 1;
    private int[] bDT;
    private ArrayList<PersonalGroupFragment> esq;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.esq = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.esq.add(personalGroupFragment);
        if (z) {
            this.bDT = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.esq.add(personalGroupFragment2);
            this.bDT = new int[]{0, 1};
        }
        esp = this.bDT.length;
        Iterator<PersonalGroupFragment> it = this.esq.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.esq.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= esp || i < 0) {
            return null;
        }
        return this.esq.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return esp;
    }

    public int of(int i) {
        return this.bDT[i];
    }
}
