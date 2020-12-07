package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kBn = 1;
    private int[] gMU;
    private ArrayList<PersonalGroupFragment> kBo;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kBo = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kBo.add(personalGroupFragment);
        if (z) {
            this.gMU = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kBo.add(personalGroupFragment2);
            this.gMU = new int[]{0, 1};
        }
        kBn = this.gMU.length;
        Iterator<PersonalGroupFragment> it = this.kBo.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kBo.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kBn || i < 0) {
            return null;
        }
        return this.kBo.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return kBn;
    }

    public int EF(int i) {
        return this.gMU[i];
    }
}
