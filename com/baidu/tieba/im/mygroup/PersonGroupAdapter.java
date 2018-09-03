package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int ezV = 1;
    private int[] bGF;
    private ArrayList<PersonalGroupFragment> ezW;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.ezW = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.ezW.add(personalGroupFragment);
        if (z) {
            this.bGF = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.ezW.add(personalGroupFragment2);
            this.bGF = new int[]{0, 1};
        }
        ezV = this.bGF.length;
        Iterator<PersonalGroupFragment> it = this.ezW.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.ezW.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= ezV || i < 0) {
            return null;
        }
        return this.ezW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ezV;
    }

    public int oA(int i) {
        return this.bGF[i];
    }
}
