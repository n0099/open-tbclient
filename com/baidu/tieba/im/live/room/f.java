package com.baidu.tieba.im.live.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
import protobuf.QueryLiveGroupLikeList.LikeUserInfo;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.c {
    private LiveGroupLikeListActivity a;
    private b b;
    private View c;
    private NavigationBar d;
    private View e;
    private View f;
    private View g;
    private TextView h;
    private BdListView i;
    private View j;
    private TextView k;
    private TextView l;
    private ProgressBar m;

    public f(LiveGroupLikeListActivity liveGroupLikeListActivity, String str, int i) {
        super(liveGroupLikeListActivity);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.a = liveGroupLikeListActivity;
        this.a.setContentView(com.baidu.tieba.w.live_group_like_list_activity);
        this.c = this.a.findViewById(com.baidu.tieba.v.zan_list_page_parent);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.v.zan_list_page_navigationbar);
        this.e = this.a.findViewById(com.baidu.tieba.v.zan_list_page_has_data_parent);
        this.f = this.a.findViewById(com.baidu.tieba.v.zan_list_page_no_data_parent);
        this.i = (BdListView) this.a.findViewById(com.baidu.tieba.v.zan_list_page_list);
        this.m = (ProgressBar) this.a.findViewById(com.baidu.tieba.v.zan_list_page_progress);
        this.b = new b(this.a);
        this.i.setAdapter((ListAdapter) this.b);
        this.i.setOnScrollListener(this.b);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LayoutInflater from = LayoutInflater.from(this.a);
        this.g = from.inflate(com.baidu.tieba.w.live_group_like_list_head, (ViewGroup) null);
        this.g.setOnClickListener(this.a);
        this.h = (TextView) this.g.findViewById(com.baidu.tieba.v.zan_list_head_text);
        if (i > 0) {
            this.d.a(String.format(this.a.getString(com.baidu.tieba.y.like_list_title_count), Integer.valueOf(i)));
        } else {
            this.d.a("");
        }
        this.h.setText(str);
        this.i.addHeaderView(this.g);
        this.j = from.inflate(com.baidu.tieba.w.live_group_like_list_foot, (ViewGroup) null);
        this.k = (TextView) this.j.findViewById(com.baidu.tieba.v.zan_list_foot_text_continue);
        this.l = (TextView) this.j.findViewById(com.baidu.tieba.v.zan_list_foot_text_more);
        this.k.setOnClickListener(this.a);
        this.i.addFooterView(this.j);
        this.i.setOnItemClickListener(this.a);
    }

    public void a(int i, List<LikeUserInfo> list, int i2, int i3) {
        this.m.setVisibility(8);
        if (i > 0) {
            this.d.a(String.format(this.a.getString(com.baidu.tieba.y.like_list_title_count), Integer.valueOf(i)));
        } else {
            this.d.a("");
        }
        if (list == null || list.size() < 1) {
            a();
            return;
        }
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.b.a(list);
        this.b.notifyDataSetChanged();
        switch (i2) {
            case MessageTypes.CMD_UPDATE_CLIENT_INFO /* 1001 */:
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                return;
            case MessageTypes.CMD_GROUP_UPDATE /* 1002 */:
                this.j.setVisibility(8);
                return;
            case MessageTypes.CMD_PING /* 1003 */:
                this.j.setVisibility(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    this.j.setBackgroundResource(com.baidu.tieba.u.bg_pack_1);
                } else {
                    this.j.setBackgroundResource(com.baidu.tieba.u.bg_pack);
                }
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                this.l.setText(String.format(this.a.getString(com.baidu.tieba.y.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.j.setVisibility(8);
                return;
        }
    }

    public void a() {
        this.m.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(0);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.a(i == 1);
        cVar.a(this.c);
        cVar.a(this.g);
        cVar.a(this.j);
        this.d.c(i);
        if (i == 1) {
            this.j.setBackgroundResource(com.baidu.tieba.u.bg_pack_1);
        } else {
            this.j.setBackgroundResource(com.baidu.tieba.u.bg_pack);
        }
    }

    public View b() {
        return this.g;
    }

    public View c() {
        return this.k;
    }
}
