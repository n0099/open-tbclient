package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int efS = 1;
    private int[] bvg;
    private ArrayList<PersonalGroupFragment> efT;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.efT = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.efT.add(personalGroupFragment);
        if (z) {
            this.bvg = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.efT.add(personalGroupFragment2);
            this.bvg = new int[]{0, 1};
        }
        efS = this.bvg.length;
        Iterator<PersonalGroupFragment> it = this.efT.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.efT.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= efS || i < 0) {
            return null;
        }
        return this.efT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return efS;
    }

    public int nU(int i) {
        return this.bvg[i];
    }
}
