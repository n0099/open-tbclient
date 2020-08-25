package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int jxf = 1;
    private int[] fYO;
    private ArrayList<PersonalGroupFragment> jxg;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.jxg = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.jxg.add(personalGroupFragment);
        if (z) {
            this.fYO = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.jxg.add(personalGroupFragment2);
            this.fYO = new int[]{0, 1};
        }
        jxf = this.fYO.length;
        Iterator<PersonalGroupFragment> it = this.jxg.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.jxg.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= jxf || i < 0) {
            return null;
        }
        return this.jxg.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return jxf;
    }

    public int BF(int i) {
        return this.fYO[i];
    }
}
