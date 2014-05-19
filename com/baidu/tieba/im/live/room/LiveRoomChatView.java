package com.baidu.tieba.im.live.room;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.LivePlayingImageView;
import com.baidu.tieba.im.chat.CommonGroupMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.dd;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* loaded from: classes.dex */
public class LiveRoomChatView extends CommonGroupMsglistView {
    private int A;
    private boolean B;
    public boolean k;
    private ag l;
    private LiveRoomChatForcast m;
    private an n;
    private View o;
    private com.baidu.tbadk.core.view.i p;
    private bc q;
    private Button r;
    private Button s;
    private Button t;
    private Activity u;
    private LivePlayingImageView v;
    private ImageView w;
    private boolean x;
    private int y;
    private boolean z;

    public ag Q() {
        return this.l;
    }

    public boolean R() {
        return this.B;
    }

    public void c(boolean z) {
        this.B = z;
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(str);
        }
    }

    public void a(ChatMessage chatMessage) {
        this.l.a(chatMessage);
    }

    public void d(boolean z) {
        this.z = z;
        this.l.setIsHost(z);
        this.k = true;
        aj();
    }

    public void d(int i) {
        a(i, true);
    }

    public int S() {
        return this.A;
    }

    public void a(int i, boolean z) {
        this.A = i;
        if (z) {
            if (this.l != null) {
                this.l.a(i, this.k);
            }
            T();
        }
        this.k = false;
    }

    public void T() {
        if (this.A == 3) {
            ad();
        } else if (this.A == 5 || this.A == 1) {
            ae();
        } else if (this.A == 6 && this.z) {
            ae();
        }
        if (this.x && !this.B) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
    }

    public void U() {
        if (this.z) {
            V().setVisibility(0);
        } else {
            V().setVisibility(8);
        }
    }

    private void aj() {
        if (this.z) {
            this.l.getmLiveRoomLike().setVisibility(8);
            this.l.getSettingButton().setVisibility(0);
            return;
        }
        this.l.getmLiveRoomLike().setVisibility(0);
        V().setVisibility(8);
        this.t.setVisibility(8);
        this.r.setVisibility(8);
        this.l.getSettingButton().setVisibility(8);
    }

    public LiveRoomChatForcast V() {
        return this.m;
    }

    public an W() {
        return this.n;
    }

    public View X() {
        return this.o;
    }

    public bc Y() {
        return this.q;
    }

    public void a(List<MetaData> list, int i, int i2) {
        this.n.a(list, i);
        if (i > 0) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        this.l.setData(i2);
    }

    public LiveRoomChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.p = null;
        this.q = null;
        this.x = true;
        this.y = -1;
        this.z = false;
        this.A = 5;
        this.k = false;
        a(msglistActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public void a(dd ddVar, boolean z) {
        super.a(ddVar, z);
        this.u = ddVar;
        this.l = new ag(ddVar);
        this.n = new an(ddVar);
        this.j.setOnkbdStateListener(new ap(this));
        LinearLayout linearLayout = (LinearLayout) ddVar.findViewById(com.baidu.tieba.r.view_header);
        ddVar.findViewById(com.baidu.tieba.r.btn_msgsend_govoice).setVisibility(8);
        this.g.setVisibility(8);
        linearLayout.addView(this.l);
        linearLayout.addView(this.n);
        this.m = (LiveRoomChatForcast) ((ViewStub) ddVar.findViewById(com.baidu.tieba.r.live_room_forcast_stub)).inflate();
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        View a = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.s.live_room_chat_btn, (View.OnClickListener) null);
        this.v = (LivePlayingImageView) a.findViewById(com.baidu.tieba.r.live_playing);
        this.w = (ImageView) a.findViewById(com.baidu.tieba.r.live_playing_default);
        this.v.setOnClickListener(null);
        this.v.setVisibleChangeCallback(new aq(this));
        this.o = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.s.nav_more_view, ddVar);
        this.r = (Button) ddVar.findViewById(com.baidu.tieba.r.btn_live_live);
        this.s = (Button) ddVar.findViewById(com.baidu.tieba.r.btn_live_speak);
        this.t = (Button) ddVar.findViewById(com.baidu.tieba.r.btn_live_stop);
        this.s.setVisibility(this.B ? 8 : 0);
        f();
        this.r.setOnClickListener(ddVar);
        this.s.setOnClickListener(ddVar);
        this.t.setOnClickListener(ddVar);
        W().getRoot().setOnClickListener(ddVar);
        this.l.getLiveStopHost().setOnClickListener(ddVar);
        this.l.getLiveStopHost().setOnClickListener(ddVar);
        this.l.getmLiveRoomLike().setOnClickListener(ddVar);
        this.l.getAnchorImg().setOnClickListener(ddVar);
        this.l.getLiveStopView().setOnClickListener(ddVar);
        this.l.getHeaderImage().setOnClickListener(ddVar);
        this.l.getNoteLayout().setOnClickListener(ddVar);
        this.m.getForcastBtn().setOnClickListener(ddVar);
        this.m.getLiveRoomCloseBtn().setOnClickListener(ddVar);
        linearLayout.setOnTouchListener(new ar(this));
    }

    @Override // com.baidu.tieba.im.chat.h
    public void i() {
        super.i();
        this.g.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
    }

    public NavigationBar Z() {
        return this.a;
    }

    public void e(String str) {
        if ((this.u instanceof LiveRoomChatActivity) && !TextUtils.isEmpty(str)) {
            ((LiveRoomChatActivity) this.u).w().c(str, new as(this));
        }
    }

    public void f(String str) {
        if ((this.u instanceof LiveRoomChatActivity) && !TextUtils.isEmpty(str)) {
            ((LiveRoomChatActivity) this.u).w().b(str, new at(this));
        }
    }

    public View aa() {
        return this.s;
    }

    public void e(boolean z) {
        this.B = z;
        this.s.setVisibility(z ? 8 : 0);
    }

    public View ab() {
        return this.t;
    }

    public View ac() {
        return this.r;
    }

    @Override // com.baidu.tieba.im.chat.h
    public void c() {
        ai();
    }

    public void ad() {
        if (this.x && this.z) {
            this.r.setVisibility(8);
            this.t.setVisibility(0);
        }
    }

    public void ae() {
        if (this.x && this.z) {
            this.t.setVisibility(8);
            this.r.setVisibility(0);
        }
    }

    public boolean af() {
        return this.x;
    }

    public int ag() {
        return this.y;
    }

    public void ah() {
        i();
        this.x = false;
        this.g.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
    }

    public void ai() {
        this.x = true;
        this.g.setVisibility(8);
        f();
        g();
        h();
        T();
    }

    private void a(MsglistActivity msglistActivity) {
        this.q = new bc(msglistActivity, msglistActivity);
        this.p = new com.baidu.tbadk.core.view.i(msglistActivity, this.q.a(), this.a, msglistActivity.getResources().getDrawable(com.baidu.tieba.o.custom_liveroom_more_background), null);
        this.p.a(msglistActivity);
        this.p.a((int) msglistActivity.getResources().getDimension(com.baidu.tieba.p.ds376));
    }

    public void f(boolean z) {
        if (this.p != null) {
            if (z) {
                this.q.b(true);
            } else {
                this.q.b(false);
            }
            this.q.a(this.z);
            this.p.b();
        }
    }

    @Override // com.baidu.tieba.im.chat.h
    public void z() {
        super.z();
        if (this.p != null) {
            this.p.dismiss();
        }
    }

    public void g(boolean z) {
        if (this.p != null) {
            if (z) {
                this.q.b(true);
            } else {
                this.q.b(false);
            }
            this.q.a(this.z);
            synchronized (this.p) {
                this.p.notify();
            }
            new Handler().postDelayed(new au(this), 200L);
        }
    }

    @Override // com.baidu.tieba.im.chat.h
    public void a(int i) {
        super.a(i);
        if (this.p != null) {
            this.p.a(this.f, i, this.f.getResources().getDrawable(com.baidu.tieba.o.custom_liveroom_more_background), this.f.getResources().getDrawable(com.baidu.tieba.o.custom_liveroom_more_background_1));
        }
    }
}
