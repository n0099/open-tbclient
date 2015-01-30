package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class db extends PagerAdapter {
    private ArrayList<LiveBroadcastCard> DZ;

    public db(ArrayList<LiveBroadcastCard> arrayList) {
        this.DZ = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.DZ == null) {
            return 0;
        }
        return this.DZ.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.DZ == null || i < 0 || i >= this.DZ.size()) {
            return null;
        }
        LiveBroadcastCard liveBroadcastCard = this.DZ.get(i);
        if (liveBroadcastCard != null && liveBroadcastCard.getParent() != null && (liveBroadcastCard.getParent() instanceof ViewGroup)) {
            ((ViewGroup) liveBroadcastCard.getParent()).removeView(liveBroadcastCard);
        }
        viewGroup.addView(liveBroadcastCard);
        return this.DZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.DZ != null && i >= 0 && i < this.DZ.size()) {
            viewGroup.removeView(this.DZ.get(i));
        }
    }
}
