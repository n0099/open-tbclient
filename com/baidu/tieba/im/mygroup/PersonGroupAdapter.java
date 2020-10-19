package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int jUK = 1;
    private int[] gox;
    private ArrayList<PersonalGroupFragment> jUL;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.jUL = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.jUL.add(personalGroupFragment);
        if (z) {
            this.gox = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.jUL.add(personalGroupFragment2);
            this.gox = new int[]{0, 1};
        }
        jUK = this.gox.length;
        Iterator<PersonalGroupFragment> it = this.jUL.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.jUL.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= jUK || i < 0) {
            return null;
        }
        return this.jUL.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return jUK;
    }

    public int CM(int i) {
        return this.gox[i];
    }
}
