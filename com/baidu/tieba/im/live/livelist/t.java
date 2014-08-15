package com.baidu.tieba.im.live.livelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    private FrsLiveListActivity a;
    private List<LiveCardData> b = new ArrayList();

    public t(FrsLiveListActivity frsLiveListActivity) {
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
        return this.b.size() + 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (getItemId(i) != -1 && getItemId(i) != -2 && (itemId = (int) getItemId(i)) >= 0 && itemId < this.b.size()) {
            return this.b.get(itemId);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == 0) {
            return -1L;
        }
        if (i == this.b.size() + 1) {
            return -2L;
        }
        return i - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int itemId = (int) getItemId(i);
        if (itemId == -1) {
            return 1;
        }
        if (itemId == -2) {
            return 3;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            if (view == null) {
                return LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.live_frs_list_item_recommend_top, viewGroup, false);
            }
            return view;
        } else if (itemViewType == 3) {
            if (view == null) {
                View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.live_frs_list_item_recommend_bottom, viewGroup, false);
                ((TextView) inflate.findViewById(com.baidu.tieba.u.recommend_foot_text)).setOnClickListener(new u(this));
                return inflate;
            }
            return view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.live_frs_list_item_recommend_item, viewGroup, false);
                v vVar = new v(this);
                vVar.a = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.u.recommend_card);
                view.setTag(vVar);
            }
            v vVar2 = (v) view.getTag();
            LiveCardData liveCardData = (LiveCardData) getItem(i);
            if (liveCardData != null) {
                vVar2.a.setStatisticsKey("forum_live_list");
                vVar2.a.setData(liveCardData);
                return view;
            }
            return view;
        }
    }
}
