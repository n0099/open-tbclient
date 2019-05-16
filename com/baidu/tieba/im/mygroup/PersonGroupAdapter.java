package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gHP = 1;
    private int[] dzY;
    private ArrayList<PersonalGroupFragment> gHQ;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gHQ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gHQ.add(personalGroupFragment);
        if (z) {
            this.dzY = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gHQ.add(personalGroupFragment2);
            this.dzY = new int[]{0, 1};
        }
        gHP = this.dzY.length;
        Iterator<PersonalGroupFragment> it = this.gHQ.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gHQ.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gHP || i < 0) {
            return null;
        }
        return this.gHQ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gHP;
    }

    public int vq(int i) {
        return this.dzY[i];
    }
}
