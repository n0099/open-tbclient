package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int faI = 1;
    private int[] car;
    private ArrayList<PersonalGroupFragment> faJ;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.faJ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.faJ.add(personalGroupFragment);
        if (z) {
            this.car = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.faJ.add(personalGroupFragment2);
            this.car = new int[]{0, 1};
        }
        faI = this.car.length;
        Iterator<PersonalGroupFragment> it = this.faJ.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.faJ.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= faI || i < 0) {
            return null;
        }
        return this.faJ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return faI;
    }

    public int qD(int i) {
        return this.car[i];
    }
}
