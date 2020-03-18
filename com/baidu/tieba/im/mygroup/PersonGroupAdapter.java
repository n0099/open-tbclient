package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int hJs = 1;
    private int[] eDT;
    private ArrayList<PersonalGroupFragment> hJt;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.hJt = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.hJt.add(personalGroupFragment);
        if (z) {
            this.eDT = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.hJt.add(personalGroupFragment2);
            this.eDT = new int[]{0, 1};
        }
        hJs = this.eDT.length;
        Iterator<PersonalGroupFragment> it = this.hJt.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.hJt.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= hJs || i < 0) {
            return null;
        }
        return this.hJt.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return hJs;
    }

    public int wX(int i) {
        return this.eDT[i];
    }
}
