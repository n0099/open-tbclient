package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends FragmentPagerAdapter {
    public static int eKZ = 1;
    private int[] clc;
    private ArrayList<c> eLa;

    public a(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eLa = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        c cVar = new c();
        cVar.setArguments(bundle);
        this.eLa.add(cVar);
        if (z) {
            this.clc = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            c cVar2 = new c();
            cVar2.setArguments(bundle2);
            this.eLa.add(cVar2);
            this.clc = new int[]{0, 1};
        }
        eKZ = this.clc.length;
        Iterator<c> it = this.eLa.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eLa.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eKZ || i < 0) {
            return null;
        }
        return this.eLa.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eKZ;
    }

    public int qx(int i) {
        return this.clc[i];
    }
}
