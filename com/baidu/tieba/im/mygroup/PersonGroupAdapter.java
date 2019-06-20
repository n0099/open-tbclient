package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gHS = 1;
    private int[] dzZ;
    private ArrayList<PersonalGroupFragment> gHT;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gHT = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gHT.add(personalGroupFragment);
        if (z) {
            this.dzZ = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gHT.add(personalGroupFragment2);
            this.dzZ = new int[]{0, 1};
        }
        gHS = this.dzZ.length;
        Iterator<PersonalGroupFragment> it = this.gHT.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gHT.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gHS || i < 0) {
            return null;
        }
        return this.gHT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gHS;
    }

    public int vq(int i) {
        return this.dzZ[i];
    }
}
