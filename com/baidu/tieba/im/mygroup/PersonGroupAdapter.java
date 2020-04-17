package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int iti = 1;
    private int[] fin;
    private ArrayList<PersonalGroupFragment> itj;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.itj = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.itj.add(personalGroupFragment);
        if (z) {
            this.fin = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.itj.add(personalGroupFragment2);
            this.fin = new int[]{0, 1};
        }
        iti = this.fin.length;
        Iterator<PersonalGroupFragment> it = this.itj.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.itj.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= iti || i < 0) {
            return null;
        }
        return this.itj.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return iti;
    }

    public int xv(int i) {
        return this.fin[i];
    }
}
