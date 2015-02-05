package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends FragmentPagerAdapter {
    public static int bkC = 1;
    private int[] bkD;
    private ArrayList<m> bkE;

    public i(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.bkE = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        m mVar = new m();
        mVar.setArguments(bundle);
        this.bkE.add(mVar);
        if (z) {
            this.bkD = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            m mVar2 = new m();
            mVar2.setArguments(bundle2);
            this.bkE.add(mVar2);
            this.bkD = new int[]{0, 1};
        }
        bkC = this.bkD.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= bkC || i < 0) {
            return null;
        }
        return this.bkE.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bkC;
    }

    public int gx(int i) {
        return this.bkD[i];
    }
}
