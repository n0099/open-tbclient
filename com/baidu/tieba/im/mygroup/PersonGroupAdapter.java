package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static int f17473c = 1;

    /* renamed from: a  reason: collision with root package name */
    public int[] f17474a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PersonalGroupFragment> f17475b;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.f17475b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.f17475b.add(personalGroupFragment);
        if (z) {
            this.f17474a = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.f17475b.add(personalGroupFragment2);
            this.f17474a = new int[]{0, 1};
        }
        f17473c = this.f17474a.length;
        Iterator<PersonalGroupFragment> it = this.f17475b.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.f17475b.size());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f17473c;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (i2 >= f17473c || i2 < 0) {
            return null;
        }
        return this.f17475b.get(i2);
    }

    public int i(int i2) {
        return this.f17474a[i2];
    }
}
