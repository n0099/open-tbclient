package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int efV = 1;
    private int[] bvg;
    private ArrayList<PersonalGroupFragment> efW;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.efW = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.efW.add(personalGroupFragment);
        if (z) {
            this.bvg = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.efW.add(personalGroupFragment2);
            this.bvg = new int[]{0, 1};
        }
        efV = this.bvg.length;
        Iterator<PersonalGroupFragment> it = this.efW.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.efW.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= efV || i < 0) {
            return null;
        }
        return this.efW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return efV;
    }

    public int nU(int i) {
        return this.bvg[i];
    }
}
