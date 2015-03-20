package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ci extends PagerAdapter {
    private ArrayList<LiveBroadcastCard> PL;

    public ci(ArrayList<LiveBroadcastCard> arrayList) {
        this.PL = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.PL == null) {
            return 0;
        }
        return this.PL.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.PL == null || i < 0 || i >= this.PL.size()) {
            return null;
        }
        LiveBroadcastCard liveBroadcastCard = this.PL.get(i);
        if (liveBroadcastCard != null && liveBroadcastCard.getParent() != null && (liveBroadcastCard.getParent() instanceof ViewGroup)) {
            ((ViewGroup) liveBroadcastCard.getParent()).removeView(liveBroadcastCard);
        }
        viewGroup.addView(liveBroadcastCard);
        return this.PL.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.PL != null && i >= 0 && i < this.PL.size()) {
            viewGroup.removeView(this.PL.get(i));
        }
    }
}
