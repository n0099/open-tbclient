package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int eQo = 1;
    private int[] bVK;
    private ArrayList<PersonalGroupFragment> eQp;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eQp = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.eQp.add(personalGroupFragment);
        if (z) {
            this.bVK = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.eQp.add(personalGroupFragment2);
            this.bVK = new int[]{0, 1};
        }
        eQo = this.bVK.length;
        Iterator<PersonalGroupFragment> it = this.eQp.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eQp.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eQo || i < 0) {
            return null;
        }
        return this.eQp.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eQo;
    }

    public int pV(int i) {
        return this.bVK[i];
    }
}
