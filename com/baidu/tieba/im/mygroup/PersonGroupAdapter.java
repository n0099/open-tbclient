package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int eZU = 1;
    private int[] bZF;
    private ArrayList<PersonalGroupFragment> eZV;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eZV = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.eZV.add(personalGroupFragment);
        if (z) {
            this.bZF = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.eZV.add(personalGroupFragment2);
            this.bZF = new int[]{0, 1};
        }
        eZU = this.bZF.length;
        Iterator<PersonalGroupFragment> it = this.eZV.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eZV.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eZU || i < 0) {
            return null;
        }
        return this.eZV.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eZU;
    }

    public int qC(int i) {
        return this.bZF[i];
    }
}
