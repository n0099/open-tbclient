package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends FragmentPagerAdapter {
    public static int eLp = 1;
    private int[] clf;
    private ArrayList<c> eLq;

    public a(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eLq = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        c cVar = new c();
        cVar.setArguments(bundle);
        this.eLq.add(cVar);
        if (z) {
            this.clf = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            c cVar2 = new c();
            cVar2.setArguments(bundle2);
            this.eLq.add(cVar2);
            this.clf = new int[]{0, 1};
        }
        eLp = this.clf.length;
        Iterator<c> it = this.eLq.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eLq.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eLp || i < 0) {
            return null;
        }
        return this.eLq.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eLp;
    }

    public int qy(int i) {
        return this.clf[i];
    }
}
