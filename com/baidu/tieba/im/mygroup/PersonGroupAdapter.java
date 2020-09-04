package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int jxl = 1;
    private int[] fYS;
    private ArrayList<PersonalGroupFragment> jxm;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.jxm = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.jxm.add(personalGroupFragment);
        if (z) {
            this.fYS = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.jxm.add(personalGroupFragment2);
            this.fYS = new int[]{0, 1};
        }
        jxl = this.fYS.length;
        Iterator<PersonalGroupFragment> it = this.jxm.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.jxm.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= jxl || i < 0) {
            return null;
        }
        return this.jxm.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return jxl;
    }

    public int BF(int i) {
        return this.fYS[i];
    }
}
