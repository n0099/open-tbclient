package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int hHG = 1;
    private int[] eDk;
    private ArrayList<PersonalGroupFragment> hHH;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.hHH = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.hHH.add(personalGroupFragment);
        if (z) {
            this.eDk = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.hHH.add(personalGroupFragment2);
            this.eDk = new int[]{0, 1};
        }
        hHG = this.eDk.length;
        Iterator<PersonalGroupFragment> it = this.hHH.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.hHH.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= hHG || i < 0) {
            return null;
        }
        return this.hHH.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return hHG;
    }

    public int wP(int i) {
        return this.eDk[i];
    }
}
