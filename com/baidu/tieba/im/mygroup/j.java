package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends FragmentPagerAdapter {
    public static int bfU = 1;
    private int[] bfV;
    private ArrayList<n> bfW;

    public j(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.bfW = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        n nVar = new n();
        nVar.setArguments(bundle);
        this.bfW.add(nVar);
        if (z) {
            this.bfV = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            n nVar2 = new n();
            nVar2.setArguments(bundle2);
            this.bfW.add(nVar2);
            this.bfV = new int[]{0, 1};
        }
        bfU = this.bfV.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= bfU || i < 0) {
            return null;
        }
        return this.bfW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bfU;
    }

    public int gf(int i) {
        return this.bfV[i];
    }
}
