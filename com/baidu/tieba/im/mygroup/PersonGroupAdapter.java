package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kGD = 1;
    private int[] gYG;
    private ArrayList<PersonalGroupFragment> kGE;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kGE = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kGE.add(personalGroupFragment);
        if (z) {
            this.gYG = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kGE.add(personalGroupFragment2);
            this.gYG = new int[]{0, 1};
        }
        kGD = this.gYG.length;
        Iterator<PersonalGroupFragment> it = this.kGE.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kGE.size());
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kGD || i < 0) {
            return null;
        }
        return this.kGE.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return kGD;
    }

    public int Ey(int i) {
        return this.gYG[i];
    }
}
