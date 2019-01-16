package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class PersonGroupAdapter extends FragmentPagerAdapter {
    public static int faH = 1;
    private int[] caq;
    private ArrayList<PersonalGroupFragment> faI;

    public PersonGroupAdapter(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.faI = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        PersonalGroupFragment personalGroupFragment = new PersonalGroupFragment();
        personalGroupFragment.setArguments(bundle);
        this.faI.add(personalGroupFragment);
        if (z) {
            this.caq = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            PersonalGroupFragment personalGroupFragment2 = new PersonalGroupFragment();
            personalGroupFragment2.setArguments(bundle2);
            this.faI.add(personalGroupFragment2);
            this.caq = new int[]{0, 1};
        }
        faH = this.caq.length;
        Iterator<PersonalGroupFragment> it = this.faI.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.faI.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= faH || i < 0) {
            return null;
        }
        return this.faI.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return faH;
    }

    public int qD(int i) {
        return this.caq[i];
    }
}
