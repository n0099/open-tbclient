package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kBY = 1;
    private int[] gUa;
    private ArrayList<PersonalGroupFragment> kBZ;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kBZ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kBZ.add(personalGroupFragment);
        if (z) {
            this.gUa = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kBZ.add(personalGroupFragment2);
            this.gUa = new int[]{0, 1};
        }
        kBY = this.gUa.length;
        Iterator<PersonalGroupFragment> it = this.kBZ.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kBZ.size());
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kBY || i < 0) {
            return null;
        }
        return this.kBZ.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return kBY;
    }

    public int CR(int i) {
        return this.gUa[i];
    }
}
