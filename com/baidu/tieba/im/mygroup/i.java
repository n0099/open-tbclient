package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends FragmentPagerAdapter {
    public static int bjg = 1;
    private int[] bjh;
    private ArrayList<m> bji;

    public i(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.bji = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        m mVar = new m();
        mVar.setArguments(bundle);
        this.bji.add(mVar);
        if (z) {
            this.bjh = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            m mVar2 = new m();
            mVar2.setArguments(bundle2);
            this.bji.add(mVar2);
            this.bjh = new int[]{0, 1};
        }
        bjg = this.bjh.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= bjg || i < 0) {
            return null;
        }
        return this.bji.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bjg;
    }

    public int go(int i) {
        return this.bjh[i];
    }
}
