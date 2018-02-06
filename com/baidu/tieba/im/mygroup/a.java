package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a extends FragmentPagerAdapter {
    public static int eLl = 1;
    private int[] clo;
    private ArrayList<c> eLm;

    public a(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.eLm = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        c cVar = new c();
        cVar.setArguments(bundle);
        this.eLm.add(cVar);
        if (z) {
            this.clo = new int[]{0};
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            c cVar2 = new c();
            cVar2.setArguments(bundle2);
            this.eLm.add(cVar2);
            this.clo = new int[]{0, 1};
        }
        eLl = this.clo.length;
        Iterator<c> it = this.eLm.iterator();
        while (it.hasNext()) {
            it.next().getArguments().putInt("page_size", this.eLm.size());
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= eLl || i < 0) {
            return null;
        }
        return this.eLm.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return eLl;
    }

    public int qx(int i) {
        return this.clo[i];
    }
}
