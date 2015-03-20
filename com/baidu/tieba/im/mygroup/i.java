package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends FragmentPagerAdapter {
    public static int blr = 1;
    private int[] bls;
    private ArrayList<m> blt;

    public i(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.blt = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        m mVar = new m();
        mVar.setArguments(bundle);
        this.blt.add(mVar);
        if (z) {
            this.bls = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            m mVar2 = new m();
            mVar2.setArguments(bundle2);
            this.blt.add(mVar2);
            this.bls = new int[]{0, 1};
        }
        blr = this.bls.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= blr || i < 0) {
            return null;
        }
        return this.blt.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return blr;
    }

    public int gi(int i) {
        return this.bls[i];
    }
}
