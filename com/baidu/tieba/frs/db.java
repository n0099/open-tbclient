package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class db extends PagerAdapter {
    private ArrayList<LiveBroadcastCard> DW;

    public db(ArrayList<LiveBroadcastCard> arrayList) {
        this.DW = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.DW == null) {
            return 0;
        }
        return this.DW.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.DW == null || i < 0 || i >= this.DW.size()) {
            return null;
        }
        LiveBroadcastCard liveBroadcastCard = this.DW.get(i);
        if (liveBroadcastCard != null && liveBroadcastCard.getParent() != null && (liveBroadcastCard.getParent() instanceof ViewGroup)) {
            ((ViewGroup) liveBroadcastCard.getParent()).removeView(liveBroadcastCard);
        }
        viewGroup.addView(liveBroadcastCard);
        return this.DW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.DW != null && i >= 0 && i < this.DW.size()) {
            viewGroup.removeView(this.DW.get(i));
        }
    }
}
