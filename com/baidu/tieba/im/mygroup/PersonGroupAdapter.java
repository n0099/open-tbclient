package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int eXd = 1;
    private int[] bZC;
    private ArrayList<PersonalGroupFragment> eXe;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eXe = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.eXe.add(personalGroupFragment);
        if (z) {
            this.bZC = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.eXe.add(personalGroupFragment2);
            this.bZC = new int[]{0, 1};
        }
        eXd = this.bZC.length;
        Iterator<PersonalGroupFragment> it = this.eXe.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eXe.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eXd || i < 0) {
            return null;
        }
        return this.eXe.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eXd;
    }

    public int qp(int i) {
        return this.bZC[i];
    }
}
