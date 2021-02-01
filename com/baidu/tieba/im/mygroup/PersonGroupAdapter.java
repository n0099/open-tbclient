package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int kKd = 1;
    private int[] gWK;
    private ArrayList<PersonalGroupFragment> kKe;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.kKe = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.kKe.add(personalGroupFragment);
        if (z) {
            this.gWK = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.kKe.add(personalGroupFragment2);
            this.gWK = new int[]{0, 1};
        }
        kKd = this.gWK.length;
        Iterator<PersonalGroupFragment> it = this.kKe.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.kKe.size());
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= kKd || i < 0) {
            return null;
        }
        return this.kKe.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return kKd;
    }

    public int Dj(int i) {
        return this.gWK[i];
    }
}
