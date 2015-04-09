package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends FragmentPagerAdapter {
    public static int blH = 1;
    private int[] blI;
    private ArrayList<m> blJ;

    public i(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.blJ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        m mVar = new m();
        mVar.setArguments(bundle);
        this.blJ.add(mVar);
        if (z) {
            this.blI = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            m mVar2 = new m();
            mVar2.setArguments(bundle2);
            this.blJ.add(mVar2);
            this.blI = new int[]{0, 1};
        }
        blH = this.blI.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= blH || i < 0) {
            return null;
        }
        return this.blJ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return blH;
    }

    public int gk(int i) {
        return this.blI[i];
    }
}
