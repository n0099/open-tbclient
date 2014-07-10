package com.baidu.tieba.im.live.livelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private FrsLiveListActivity a;
    private List<LiveCardData> b = new ArrayList();
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private s g;

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public void a(int i, boolean z) {
        for (LiveCardData liveCardData : this.b) {
            if (liveCardData.getGroupId() == i) {
                liveCardData.setFlag(z ? 2 : 0);
            }
        }
    }

    public void d(boolean z) {
        this.e = z;
    }

    public void a(s sVar) {
        this.g = sVar;
    }

    public p(FrsLiveListActivity frsLiveListActivity) {
        this.a = frsLiveListActivity;
    }

    public void a(List<LiveCardData> list) {
        this.b.addAll(list);
    }

    public void a() {
        this.b.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (getItemId(i) != -1 && i >= 0 && i < this.b.size()) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.b.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) == -1 ? -1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == -1) {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.live_list_foot, viewGroup, false);
                r rVar = new r(this);
                rVar.d = view.findViewById(com.baidu.tieba.v.bottom_line);
                rVar.e = (ViewGroup) view.findViewById(com.baidu.tieba.v.bottom_more);
                rVar.f = (TextView) view.findViewById(com.baidu.tieba.v.more_title);
                rVar.g = (ProgressBar) view.findViewById(com.baidu.tieba.v.more_progress);
                view.setTag(rVar);
            }
            r rVar2 = (r) view.getTag();
            if (this.f || this.d) {
                rVar2.d.setVisibility(0);
                rVar2.e.setVisibility(8);
            } else {
                rVar2.d.setVisibility(8);
                rVar2.e.setVisibility(0);
                if (this.c) {
                    rVar2.f.setText(com.baidu.tieba.y.live_frs_list_hasmore);
                    rVar2.g.setVisibility(0);
                } else {
                    rVar2.f.setText(com.baidu.tieba.y.live_frs_list_nomore);
                    rVar2.g.setVisibility(8);
                }
            }
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.live_frs_list_item_native, viewGroup, false);
                r rVar3 = new r(this);
                rVar3.a = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.item_card);
                rVar3.c = view.findViewById(com.baidu.tieba.v.live_list_item_line);
                rVar3.b = (ViewGroup) view.findViewById(com.baidu.tieba.v.item_operate);
                view.setTag(rVar3);
            }
            r rVar4 = (r) view.getTag();
            LiveCardData liveCardData = (LiveCardData) getItem(i);
            if (liveCardData != null) {
                rVar4.a.setStatisticsKey("forum_live_list");
                rVar4.a.setIsTopTipShow(liveCardData.getFlag() == 1);
                rVar4.a.setIsHideSHow(liveCardData.getFlag() == 2);
                rVar4.a.setData(liveCardData);
                rVar4.c.setVisibility(i == 0 ? 8 : 0);
                rVar4.b.setVisibility(this.e ? 0 : 8);
                rVar4.b.setTag(liveCardData);
                rVar4.b.setOnClickListener(new q(this));
            }
        }
        return view;
    }
}
