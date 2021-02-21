package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kKr = 1;
    private int[] gWY;
    private ArrayList<PersonalGroupFragment> kKs;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kKs = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kKs.add(personalGroupFragment);
        if (z) {
            this.gWY = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kKs.add(personalGroupFragment2);
            this.gWY = new int[]{0, 1};
        }
        kKr = this.gWY.length;
        Iterator<PersonalGroupFragment> it = this.kKs.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kKs.size());
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kKr || i < 0) {
            return null;
        }
        return this.kKs.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return kKr;
    }

    public int Dj(int i) {
        return this.gWY[i];
    }
}
