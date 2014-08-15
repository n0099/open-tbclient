package com.baidu.tieba.im.live.livelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.f {
    private LiveGroupHistoryActivity a;
    private ai b;
    private ViewGroup c;
    private NavigationBar d;
    private ViewGroup e;
    private LiveBroadcastCard f;
    private BdListView g;
    private TextView h;

    public ak(LiveGroupHistoryActivity liveGroupHistoryActivity) {
        super(liveGroupHistoryActivity);
        this.a = liveGroupHistoryActivity;
        liveGroupHistoryActivity.setContentView(com.baidu.tieba.v.live_group_history_activity);
        a(liveGroupHistoryActivity);
        b(liveGroupHistoryActivity);
    }

    private void a(LiveGroupHistoryActivity liveGroupHistoryActivity) {
        this.c = (ViewGroup) this.a.findViewById(com.baidu.tieba.u.rootView);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d.a(this.a.getString(com.baidu.tieba.x.live_group_histroy_title));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    private void b(LiveGroupHistoryActivity liveGroupHistoryActivity) {
        this.e = (ViewGroup) this.a.findViewById(com.baidu.tieba.u.card_layout);
        this.f = (LiveBroadcastCard) this.a.findViewById(com.baidu.tieba.u.group_card);
        this.g = (BdListView) this.a.findViewById(com.baidu.tieba.u.history_list);
        this.h = (TextView) this.a.findViewById(com.baidu.tieba.u.history_nodata);
        this.b = new ai(this.a);
        this.g.setAdapter((ListAdapter) this.b);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.d.c(i);
    }

    public void a() {
        this.e.setVisibility(0);
    }

    public void b() {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void c() {
        this.b.notifyDataSetChanged();
    }

    public BdListView d() {
        return this.g;
    }

    public ai e() {
        return this.b;
    }

    public LiveBroadcastCard f() {
        return this.f;
    }
}
