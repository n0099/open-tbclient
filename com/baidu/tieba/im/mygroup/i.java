package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends FragmentPagerAdapter {
    public static int bkD = 1;
    private int[] bkE;
    private ArrayList<m> bkF;

    public i(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.bkF = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        m mVar = new m();
        mVar.setArguments(bundle);
        this.bkF.add(mVar);
        if (z) {
            this.bkE = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            m mVar2 = new m();
            mVar2.setArguments(bundle2);
            this.bkF.add(mVar2);
            this.bkE = new int[]{0, 1};
        }
        bkD = this.bkE.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= bkD || i < 0) {
            return null;
        }
        return this.bkF.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bkD;
    }

    public int gx(int i) {
        return this.bkE[i];
    }
}
