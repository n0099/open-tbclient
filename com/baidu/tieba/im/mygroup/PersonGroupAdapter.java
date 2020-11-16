package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes25.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int knR = 1;
    private int[] gDX;
    private ArrayList<PersonalGroupFragment> knS;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.knS = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.knS.add(personalGroupFragment);
        if (z) {
            this.gDX = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.knS.add(personalGroupFragment2);
            this.gDX = new int[]{0, 1};
        }
        knR = this.gDX.length;
        Iterator<PersonalGroupFragment> it = this.knS.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.knS.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= knR || i < 0) {
            return null;
        }
        return this.knS.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return knR;
    }

    public int DQ(int i) {
        return this.gDX[i];
    }
}
