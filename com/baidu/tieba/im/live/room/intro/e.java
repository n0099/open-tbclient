package com.baidu.tieba.im.live.room.intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private ab a;
    private View b;
    private NavigationBar c;
    private BdListView d;
    private b e;
    private View f;
    private HeadImageView g;
    private TextView h;
    private TextView i;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;
    private View n;
    private ProgressBar o;
    private String p;
    private String q;
    private final View.OnClickListener r;

    public e(LiveRoomIntroActivity liveRoomIntroActivity) {
        super(liveRoomIntroActivity);
        this.a = null;
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
        this.n = null;
        this.o = null;
        this.r = new f(this);
        this.mContext = liveRoomIntroActivity;
        this.a = new ab(liveRoomIntroActivity);
        liveRoomIntroActivity.setContentView(s.live_room_intro);
        this.b = liveRoomIntroActivity.findViewById(r.live_room_intro_root);
        this.c = (NavigationBar) liveRoomIntroActivity.findViewById(r.live_room_intro_navigationbar);
        this.c.a(u.live_chat_room_more_intro);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.o = (ProgressBar) liveRoomIntroActivity.findViewById(r.live_room_intro_listview_progress);
        this.d = (BdListView) liveRoomIntroActivity.findViewById(r.live_room_intro_listview);
        this.e = new b(liveRoomIntroActivity);
        this.d.setAdapter((ListAdapter) this.e);
        LayoutInflater from = LayoutInflater.from(liveRoomIntroActivity);
        this.f = from.inflate(s.live_room_intro_head_host, (ViewGroup) null);
        this.g = (HeadImageView) this.f.findViewById(r.live_room_intro_head_host_head);
        this.h = (TextView) this.f.findViewById(r.live_room_intro_head_host_name);
        this.i = (TextView) this.f.findViewById(r.live_room_intro_head_host_count);
        this.g.setIsRound(true);
        this.g.setOnClickListener(this.r);
        this.d.addHeaderView(this.f);
        this.j = from.inflate(s.live_room_intro_head_room, (ViewGroup) null);
        this.k = (TextView) this.j.findViewById(r.live_room_intro_root_roonum);
        this.l = (TextView) this.j.findViewById(r.live_room_intro_root_name);
        this.m = (TextView) this.j.findViewById(r.live_room_intro_root_notice);
        this.d.addHeaderView(this.j);
        this.n = from.inflate(s.live_room_intro_head_livetitle, (ViewGroup) null);
        this.d.addHeaderView(this.n);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.a(i == 1);
        cVar.a(this.b);
        cVar.a(this.j);
        cVar.a(this.n);
        this.c.c(i);
    }

    public void a(String str) {
        if (this.h != null) {
            this.h.setText(str);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
    public void a(String str, String str2, int i, int i2) {
        this.p = str2;
        this.q = new StringBuilder().append(i2).toString();
        com.baidu.adp.widget.a.a c = this.a.c(str);
        if (c != null) {
            c.a(this.g);
        } else {
            this.g.setTag(str);
            this.a.c(str, new g(this));
        }
        this.h.setText(str2);
        this.i.setText(String.valueOf(i));
    }

    public void a(int i, String str, String str2, String str3) {
        this.k.setText(new StringBuilder(String.valueOf(i)).toString());
        this.l.setText(str);
        this.m.setText(str2);
    }

    public void a(List<LiveCardData> list) {
        this.e.a(list);
        this.e.notifyDataSetChanged();
        if (list == null || list.size() < 1) {
            this.n.setVisibility(8);
            return;
        }
        this.n.setVisibility(0);
        a();
    }

    private void a() {
        if (this.d != null && this.e != null) {
            ae.a(this.d, this.e.a(), 0, -1);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }
}
