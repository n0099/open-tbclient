package com.baidu.tieba.im.live.room;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.im.chat.TalkableActivity;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.base.f {
    private View a;
    private View b;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View.OnClickListener q;
    private TalkableActivity r;

    public bd(TalkableActivity talkableActivity, View.OnClickListener onClickListener) {
        super(talkableActivity);
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
        this.p = null;
        this.q = null;
        this.r = null;
        this.r = talkableActivity;
        this.q = onClickListener;
        m();
    }

    public View a() {
        return this.a;
    }

    public void a(boolean z) {
        if (z) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.j.setVisibility(0);
        this.k.setVisibility(0);
    }

    public void b(boolean z) {
        if (z) {
            this.l.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.u.icon_live_attention_s, 0, 0);
        } else {
            this.l.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.u.icon_live_attention, 0, 0);
        }
    }

    public void c(boolean z) {
        if (z) {
            this.g.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.u.icon_live_tape_s, 0, 0);
        } else {
            this.g.setCompoundDrawablesWithIntrinsicBounds(0, com.baidu.tieba.u.icon_live_tape, 0, 0);
        }
    }

    private void m() {
        this.a = this.r.getLayoutInflater().inflate(com.baidu.tieba.w.im_chat_room_more_view, (ViewGroup) null);
        this.b = this.a.findViewById(com.baidu.tieba.v.live_room_more_view_row1_host);
        this.c = this.a.findViewById(com.baidu.tieba.v.live_room_more_view_row3_host);
        this.d = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_inform_host);
        this.d.setOnClickListener(this.q);
        this.e = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_share_host);
        this.e.setOnClickListener(this.q);
        this.f = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_review_host);
        this.g = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_tape_host);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.h = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_set_host);
        this.h.setOnClickListener(this.q);
        this.i = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_exit_host);
        this.i.setOnClickListener(this.q);
        this.j = this.a.findViewById(com.baidu.tieba.v.live_room_more_view_row1_guest);
        this.k = this.a.findViewById(com.baidu.tieba.v.live_room_more_view_row3_guest);
        this.l = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_attention_guest);
        this.l.setOnClickListener(this.q);
        this.m = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_share_guest);
        this.m.setOnClickListener(this.q);
        this.n = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_review_guest);
        this.n.setVisibility(4);
        this.o = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_intro_guest);
        this.o.setOnClickListener(this.q);
        this.p = (TextView) this.a.findViewById(com.baidu.tieba.v.live_room_more_view_exit_guest);
        this.p.setOnClickListener(this.q);
    }

    public TextView b() {
        return this.d;
    }

    public TextView c() {
        return this.e;
    }

    public TextView d() {
        return this.f;
    }

    public TextView e() {
        return this.g;
    }

    public TextView f() {
        return this.h;
    }

    public TextView g() {
        return this.i;
    }

    public TextView h() {
        return this.l;
    }

    public TextView i() {
        return this.m;
    }

    public TextView j() {
        return this.n;
    }

    public TextView k() {
        return this.o;
    }

    public TextView l() {
        return this.p;
    }
}
