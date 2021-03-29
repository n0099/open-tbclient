package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static int f18079c = 1;

    /* renamed from: a  reason: collision with root package name */
    public int[] f18080a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PersonalGroupFragment> f18081b;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.f18081b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.f18081b.add(personalGroupFragment);
        if (z) {
            this.f18080a = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.f18081b.add(personalGroupFragment2);
            this.f18080a = new int[]{0, 1};
        }
        f18079c = this.f18080a.length;
        Iterator<PersonalGroupFragment> it = this.f18081b.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.f18081b.size());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f18079c;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= f18079c || i < 0) {
            return null;
        }
        return this.f18081b.get(i);
    }

    public int i(int i) {
        return this.f18080a[i];
    }
}
