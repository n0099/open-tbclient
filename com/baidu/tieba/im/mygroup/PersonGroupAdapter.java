package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kBp = 1;
    private int[] gMW;
    private ArrayList<PersonalGroupFragment> kBq;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kBq = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kBq.add(personalGroupFragment);
        if (z) {
            this.gMW = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kBq.add(personalGroupFragment2);
            this.gMW = new int[]{0, 1};
        }
        kBp = this.gMW.length;
        Iterator<PersonalGroupFragment> it = this.kBq.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kBq.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kBp || i < 0) {
            return null;
        }
        return this.kBq.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return kBp;
    }

    public int EF(int i) {
        return this.gMW[i];
    }
}
