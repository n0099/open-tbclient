package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gHQ = 1;
    private int[] dzZ;
    private ArrayList<PersonalGroupFragment> gHR;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gHR = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gHR.add(personalGroupFragment);
        if (z) {
            this.dzZ = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gHR.add(personalGroupFragment2);
            this.dzZ = new int[]{0, 1};
        }
        gHQ = this.dzZ.length;
        Iterator<PersonalGroupFragment> it = this.gHR.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gHR.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gHQ || i < 0) {
            return null;
        }
        return this.gHR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gHQ;
    }

    public int vq(int i) {
        return this.dzZ[i];
    }
}
