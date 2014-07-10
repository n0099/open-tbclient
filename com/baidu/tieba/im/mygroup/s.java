package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends FragmentPagerAdapter {
    public static int a = 1;
    private int[] b;
    private ArrayList<w> c;

    public s(PersonGroupActivity personGroupActivity, boolean z) {
        super(personGroupActivity.getSupportFragmentManager());
        this.c = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        w wVar = new w();
        wVar.setArguments(bundle);
        this.c.add(wVar);
        if (z) {
            this.b = new int[1];
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            w wVar2 = new w();
            wVar2.setArguments(bundle2);
            this.c.add(wVar2);
            this.b = new int[]{0, 1};
        }
        a = this.b.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= a || i < 0) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return a;
    }

    public int a(int i) {
        return this.b[i];
    }
}
