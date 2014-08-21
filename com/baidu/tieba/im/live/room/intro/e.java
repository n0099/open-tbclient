package com.baidu.tieba.im.live.room.intro;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    private View a;
    private NavigationBar b;
    private BdListView c;
    private b d;
    private View e;
    private HeadImageView f;
    private TextView g;
    private TextView h;
    private View i;
    private TextView j;
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
        liveRoomIntroActivity.setContentView(v.live_room_intro);
        this.a = liveRoomIntroActivity.findViewById(u.live_room_intro_root);
        this.b = (NavigationBar) liveRoomIntroActivity.findViewById(u.live_room_intro_navigationbar);
        this.b.a(x.live_chat_room_more_intro);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.o = (ProgressBar) liveRoomIntroActivity.findViewById(u.live_room_intro_listview_progress);
        this.c = (BdListView) liveRoomIntroActivity.findViewById(u.live_room_intro_listview);
        this.d = new b(liveRoomIntroActivity);
        this.c.setAdapter((ListAdapter) this.d);
        this.e = com.baidu.adp.lib.e.b.a().a(liveRoomIntroActivity, v.live_room_intro_head_host, null);
        this.f = (HeadImageView) this.e.findViewById(u.live_room_intro_head_host_head);
        this.g = (TextView) this.e.findViewById(u.live_room_intro_head_host_name);
        this.h = (TextView) this.e.findViewById(u.live_room_intro_head_host_count);
        this.f.setIsRound(true);
        this.f.setOnClickListener(this.r);
        this.c.addHeaderView(this.e);
        this.i = com.baidu.adp.lib.e.b.a().a(liveRoomIntroActivity, v.live_room_intro_head_room, null);
        this.j = (TextView) this.i.findViewById(u.live_room_intro_root_roonum);
        this.k = (TextView) this.i.findViewById(u.live_room_intro_root_name);
        this.l = (TextView) this.i.findViewById(u.live_room_intro_root_notice);
        this.m = (TextView) this.i.findViewById(u.live_room_intro_root_from);
        this.c.addHeaderView(this.i);
        this.n = com.baidu.adp.lib.e.b.a().a(liveRoomIntroActivity, v.live_room_intro_head_livetitle, null);
        this.c.addHeaderView(this.n);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.a(i == 1);
        cVar.a(this.a);
        cVar.a(this.i);
        cVar.a(this.n);
        this.b.c(i);
    }

    public void a(String str) {
        if (this.g != null) {
            this.g.setText(str);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    public void a(String str, String str2, int i, int i2) {
        this.p = str2;
        this.q = new StringBuilder().append(i2).toString();
        this.f.a(str, 12, false);
        this.g.setText(str2);
        this.h.setText(String.valueOf(i));
    }

    public void a(int i, String str, String str2, String str3) {
        this.j.setText(new StringBuilder(String.valueOf(i)).toString());
        this.k.setText(str);
        this.l.setText(str2);
        this.m.setText(String.valueOf(str3) + "吧");
    }

    public void a(List<LiveCardData> list) {
        this.d.a(list);
        this.d.notifyDataSetChanged();
        if (list == null || list.size() < 1) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
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
