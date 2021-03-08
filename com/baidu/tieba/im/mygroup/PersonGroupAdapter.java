package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kMt = 1;
    private int[] gYH;
    private ArrayList<PersonalGroupFragment> kMu;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kMu = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kMu.add(personalGroupFragment);
        if (z) {
            this.gYH = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kMu.add(personalGroupFragment2);
            this.gYH = new int[]{0, 1};
        }
        kMt = this.gYH.length;
        Iterator<PersonalGroupFragment> it = this.kMu.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kMu.size());
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kMt || i < 0) {
            return null;
        }
        return this.kMu.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return kMt;
    }

    public int Dm(int i) {
        return this.gYH[i];
    }
}
