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
import com.baidu.tieba.im.chat.TalkableActivity;
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

    @Override // com.baidu.tieba.im.chat.g
    protected void P() {
        h();
        g();
        f();
    }

    public ag R() {
        return this.l;
    }

    public boolean S() {
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
        ak();
    }

    public void d(int i) {
        a(i, true);
    }

    public int T() {
        return this.A;
    }

    public void a(int i, boolean z) {
        this.A = i;
        if (z) {
            if (this.l != null) {
                this.l.a(i, this.k);
            }
            U();
        }
        this.k = false;
    }

    public void U() {
        if (this.A == 3) {
            ae();
        } else if (this.A == 5 || this.A == 1) {
            af();
        } else if (this.A == 6 && this.z) {
            af();
        }
        if (this.x && !this.B) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
    }

    public void V() {
        if (this.z) {
            W().setVisibility(0);
        } else {
            W().setVisibility(8);
        }
    }

    private void ak() {
        if (this.z) {
            this.l.getmLiveRoomLike().setVisibility(8);
            this.l.getSettingButton().setVisibility(0);
            return;
        }
        this.l.getmLiveRoomLike().setVisibility(0);
        W().setVisibility(8);
        this.t.setVisibility(8);
        this.r.setVisibility(8);
        this.l.getSettingButton().setVisibility(8);
    }

    public LiveRoomChatForcast W() {
        return this.m;
    }

    public an X() {
        return this.n;
    }

    public View Y() {
        return this.o;
    }

    public bc Z() {
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
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        this.u = talkableActivity;
        this.l = new ag(talkableActivity);
        this.n = new an(talkableActivity);
        this.j.setOnkbdStateListener(new ap(this));
        LinearLayout linearLayout = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.v.view_header);
        talkableActivity.findViewById(com.baidu.tieba.v.btn_msgsend_govoice).setVisibility(8);
        this.g.setVisibility(8);
        linearLayout.addView(this.l);
        linearLayout.addView(this.n);
        this.m = (LiveRoomChatForcast) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.live_room_forcast_stub)).inflate();
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        View a = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.live_room_chat_btn, (View.OnClickListener) null);
        this.v = (LivePlayingImageView) a.findViewById(com.baidu.tieba.v.live_playing);
        this.w = (ImageView) a.findViewById(com.baidu.tieba.v.live_playing_default);
        this.v.setOnClickListener(null);
        this.v.setVisibleChangeCallback(new aq(this));
        this.o = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nav_more_view, talkableActivity);
        this.r = (Button) talkableActivity.findViewById(com.baidu.tieba.v.btn_live_live);
        this.s = (Button) talkableActivity.findViewById(com.baidu.tieba.v.btn_live_speak);
        this.t = (Button) talkableActivity.findViewById(com.baidu.tieba.v.btn_live_stop);
        this.s.setVisibility(this.B ? 8 : 0);
        f();
        this.r.setOnClickListener(talkableActivity);
        this.s.setOnClickListener(talkableActivity);
        this.t.setOnClickListener(talkableActivity);
        X().getRoot().setOnClickListener(talkableActivity);
        this.l.getLiveStopHost().setOnClickListener(talkableActivity);
        this.l.getLiveStopHost().setOnClickListener(talkableActivity);
        this.l.getmLiveRoomLike().setOnClickListener(talkableActivity);
        this.l.getAnchorImg().setOnClickListener(talkableActivity);
        this.l.getLiveStopView().setOnClickListener(talkableActivity);
        this.l.getHeaderImage().setOnClickListener(talkableActivity);
        this.l.getNoteLayout().setOnClickListener(talkableActivity);
        this.m.getForcastBtn().setOnClickListener(talkableActivity);
        this.m.getLiveRoomCloseBtn().setOnClickListener(talkableActivity);
        linearLayout.setOnTouchListener(new ar(this));
    }

    @Override // com.baidu.tieba.im.chat.g
    public void i() {
        super.i();
        this.g.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.d.setCursorVisible(true);
    }

    public NavigationBar aa() {
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

    public View ab() {
        return this.s;
    }

    public void e(boolean z) {
        this.B = z;
        this.s.setVisibility(z ? 8 : 0);
    }

    public View ac() {
        return this.t;
    }

    public View ad() {
        return this.r;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void c() {
        aj();
    }

    public void ae() {
        if (this.x && this.z) {
            this.r.setVisibility(8);
            this.t.setVisibility(0);
        }
    }

    public void af() {
        if (this.x && this.z) {
            this.t.setVisibility(8);
            this.r.setVisibility(0);
        }
    }

    public boolean ag() {
        return this.x;
    }

    public int ah() {
        return this.y;
    }

    public void ai() {
        i();
        this.x = false;
        this.g.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
    }

    public void aj() {
        this.x = true;
        this.g.setVisibility(8);
        f();
        g();
        h();
        U();
    }

    private void a(MsglistActivity msglistActivity) {
        this.q = new bc(msglistActivity, msglistActivity);
        this.p = new com.baidu.tbadk.core.view.i(msglistActivity, this.q.a(), this.a, msglistActivity.getResources().getDrawable(com.baidu.tieba.s.custom_liveroom_more_background), null);
        this.p.a(msglistActivity);
        this.p.a((int) msglistActivity.getResources().getDimension(com.baidu.tieba.t.ds376));
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

    @Override // com.baidu.tieba.im.chat.g
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

    @Override // com.baidu.tieba.im.chat.g
    public void a(int i) {
        super.a(i);
        if (this.p != null) {
            this.p.a(this.f, i, this.f.getResources().getDrawable(com.baidu.tieba.s.custom_liveroom_more_background), this.f.getResources().getDrawable(com.baidu.tieba.s.custom_liveroom_more_background_1));
        }
    }
}
