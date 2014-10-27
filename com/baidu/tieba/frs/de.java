package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class de extends PagerAdapter {
    private ArrayList<View> zO;

    public de(ArrayList<View> arrayList) {
        this.zO = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.zO == null) {
            return 0;
        }
        return this.zO.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.zO == null) {
            return null;
        }
        viewGroup.addView(this.zO.get(i));
        return this.zO.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.zO != null) {
            viewGroup.removeView(this.zO.get(i));
        }
    }
}
