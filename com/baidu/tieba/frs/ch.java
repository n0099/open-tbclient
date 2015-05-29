package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ch extends PagerAdapter {
    private ArrayList<LiveBroadcastCard> Qj;

    public ch(ArrayList<LiveBroadcastCard> arrayList) {
        this.Qj = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.Qj == null) {
            return 0;
        }
        return this.Qj.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Qj == null || i < 0 || i >= this.Qj.size()) {
            return null;
        }
        LiveBroadcastCard liveBroadcastCard = this.Qj.get(i);
        if (liveBroadcastCard != null && liveBroadcastCard.getParent() != null && (liveBroadcastCard.getParent() instanceof ViewGroup)) {
            ((ViewGroup) liveBroadcastCard.getParent()).removeView(liveBroadcastCard);
        }
        viewGroup.addView(liveBroadcastCard);
        return this.Qj.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.Qj != null && i >= 0 && i < this.Qj.size()) {
            viewGroup.removeView(this.Qj.get(i));
        }
    }
}
