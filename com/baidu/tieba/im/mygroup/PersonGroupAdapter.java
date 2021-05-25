package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static int f17315c = 1;

    /* renamed from: a  reason: collision with root package name */
    public int[] f17316a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PersonalGroupFragment> f17317b;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.f17317b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.f17317b.add(personalGroupFragment);
        if (z) {
            this.f17316a = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.f17317b.add(personalGroupFragment2);
            this.f17316a = new int[]{0, 1};
        }
        f17315c = this.f17316a.length;
        Iterator<PersonalGroupFragment> it = this.f17317b.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.f17317b.size());
        }
    }

    public int b(int i2) {
        return this.f17316a[i2];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return f17315c;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (i2 >= f17315c || i2 < 0) {
            return null;
        }
        return this.f17317b.get(i2);
    }
}
