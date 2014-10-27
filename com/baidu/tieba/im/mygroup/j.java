package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends FragmentPagerAdapter {
    public static int bfG = 1;
    private int[] bfH;
    private ArrayList<n> bfI;

    public j(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.bfI = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        n nVar = new n();
        nVar.setArguments(bundle);
        this.bfI.add(nVar);
        if (z) {
            this.bfH = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            n nVar2 = new n();
            nVar2.setArguments(bundle2);
            this.bfI.add(nVar2);
            this.bfH = new int[]{0, 1};
        }
        bfG = this.bfH.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= bfG || i < 0) {
            return null;
        }
        return this.bfI.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bfG;
    }

    public int gf(int i) {
        return this.bfH[i];
    }
}
