package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int gQO = 1;
    private int[] dFl;
    private ArrayList<PersonalGroupFragment> gQP;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.gQP = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.gQP.add(personalGroupFragment);
        if (z) {
            this.dFl = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.gQP.add(personalGroupFragment2);
            this.dFl = new int[]{0, 1};
        }
        gQO = this.dFl.length;
        Iterator<PersonalGroupFragment> it = this.gQP.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.gQP.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= gQO || i < 0) {
            return null;
        }
        return this.gQP.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return gQO;
    }

    public int vX(int i) {
        return this.dFl[i];
    }
}
