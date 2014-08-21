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
    private boolean A;
    private int B;
    private boolean C;
    public boolean l;
    private aj m;
    private LiveRoomChatForcast n;
    private aq o;
    private View p;
    private com.baidu.tbadk.core.view.n q;
    private be r;
    private Button s;
    private Button t;
    private Button u;
    private Activity v;
    private LivePlayingImageView w;
    private ImageView x;
    private boolean y;
    private int z;

    @Override // com.baidu.tieba.im.chat.g
    protected void Q() {
        h();
        g();
        f();
    }

    public aj S() {
        return this.m;
    }

    public boolean T() {
        return this.C;
    }

    public void c(boolean z) {
        this.C = z;
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(str);
        }
    }

    public void e(String str) {
        this.m.setNoteText(str);
    }

    public void a(ChatMessage chatMessage) {
        this.m.a(chatMessage);
    }

    public void d(boolean z) {
        this.A = z;
        this.m.setIsHost(z);
        this.l = true;
        al();
    }

    public void d(int i) {
        a(i, true);
    }

    public int U() {
        return this.B;
    }

    public void a(int i, boolean z) {
        this.B = i;
        if (z) {
            if (this.m != null) {
                this.m.a(i, this.l);
            }
            V();
        }
        this.l = false;
    }

    public void V() {
        if (this.B == 3) {
            af();
        } else if (this.B == 5 || this.B == 1) {
            ag();
        } else if (this.B == 6 && this.A) {
            ag();
        }
        if (this.y && !this.C) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    public void W() {
        if (this.A) {
            X().setVisibility(0);
        } else {
            X().setVisibility(8);
        }
    }

    private void al() {
        if (this.A) {
            this.m.getmLiveRoomLike().setVisibility(8);
            this.m.getSettingButton().setVisibility(0);
            return;
        }
        this.m.getmLiveRoomLike().setVisibility(0);
        X().setVisibility(8);
        this.u.setVisibility(8);
        this.s.setVisibility(8);
        this.m.getSettingButton().setVisibility(8);
    }

    public LiveRoomChatForcast X() {
        return this.n;
    }

    public aq Y() {
        return this.o;
    }

    public View Z() {
        return this.p;
    }

    public be aa() {
        return this.r;
    }

    public void a(List<MetaData> list, int i, int i2) {
        this.o.a(list, i);
        if (i > 0) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        this.m.setData(i2);
    }

    public LiveRoomChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.q = null;
        this.r = null;
        this.y = true;
        this.z = -1;
        this.A = false;
        this.B = 5;
        this.l = false;
        b(msglistActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        this.v = talkableActivity;
        this.m = new aj(talkableActivity);
        this.o = new aq(talkableActivity);
        this.k.setOnkbdStateListener(new as(this));
        LinearLayout linearLayout = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.u.view_header);
        talkableActivity.findViewById(com.baidu.tieba.u.btn_msgsend_govoice).setVisibility(8);
        linearLayout.addView(this.m);
        linearLayout.addView(this.o);
        this.n = (LiveRoomChatForcast) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.u.live_room_forcast_stub)).inflate();
        this.o.setVisibility(8);
        this.n.setVisibility(8);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        View a = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.live_room_chat_btn, (View.OnClickListener) null);
        this.w = (LivePlayingImageView) a.findViewById(com.baidu.tieba.u.live_playing);
        this.x = (ImageView) a.findViewById(com.baidu.tieba.u.live_playing_default);
        this.w.setOnClickListener(null);
        this.w.setVisibleChangeCallback(new at(this));
        this.p = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nav_more_view, talkableActivity);
        this.s = (Button) talkableActivity.findViewById(com.baidu.tieba.u.btn_live_live);
        this.t = (Button) talkableActivity.findViewById(com.baidu.tieba.u.btn_live_speak);
        this.u = (Button) talkableActivity.findViewById(com.baidu.tieba.u.btn_live_stop);
        this.t.setVisibility(this.C ? 8 : 0);
        f();
        this.s.setOnClickListener(talkableActivity);
        this.t.setOnClickListener(talkableActivity);
        this.u.setOnClickListener(talkableActivity);
        Y().getRoot().setOnClickListener(talkableActivity);
        this.m.getLiveStopHost().setOnClickListener(talkableActivity);
        this.m.getLiveStopHost().setOnClickListener(talkableActivity);
        this.m.getmLiveRoomLike().setOnClickListener(talkableActivity);
        this.m.getAnchorImg().setOnClickListener(talkableActivity);
        this.m.getLiveStopView().setOnClickListener(talkableActivity);
        this.m.getHeaderImage().setOnClickListener(talkableActivity);
        this.m.getNoteLayout().setOnClickListener(talkableActivity);
        this.n.getForcastBtn().setOnClickListener(talkableActivity);
        this.n.getLiveRoomCloseBtn().setOnClickListener(talkableActivity);
        linearLayout.setOnTouchListener(new au(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void b(TalkableActivity talkableActivity) {
        super.b(talkableActivity);
        this.i.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void i() {
        super.i();
        this.i.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.d.setCursorVisible(true);
    }

    public NavigationBar ab() {
        return this.a;
    }

    public void f(String str) {
        if ((this.v instanceof LiveRoomChatActivity) && !TextUtils.isEmpty(str)) {
            this.m.setHeaderImage(str);
        }
    }

    public void g(String str) {
        if ((this.v instanceof LiveRoomChatActivity) && !TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(str, 10, new av(this), this.f.getUniqueId());
        }
    }

    public View ac() {
        return this.t;
    }

    public void e(boolean z) {
        this.C = z;
        this.t.setVisibility(z ? 8 : 0);
    }

    public View ad() {
        return this.u;
    }

    public View ae() {
        return this.s;
    }

    @Override // com.baidu.tieba.im.chat.g
    public void c() {
        ak();
    }

    public void af() {
        if (this.y && this.A) {
            this.s.setVisibility(8);
            this.u.setVisibility(0);
        }
    }

    public void ag() {
        if (this.y && this.A) {
            this.u.setVisibility(8);
            this.s.setVisibility(0);
        }
    }

    public boolean ah() {
        return this.y;
    }

    public int ai() {
        return this.z;
    }

    public void aj() {
        i();
        this.y = false;
        this.i.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
    }

    public void ak() {
        this.y = true;
        this.i.setVisibility(8);
        f();
        g();
        h();
        V();
    }

    private void b(MsglistActivity msglistActivity) {
        this.r = new be(msglistActivity, msglistActivity);
        this.q = new com.baidu.tbadk.core.view.n(msglistActivity, this.r.a(), this.a, msglistActivity.getResources().getDrawable(com.baidu.tieba.r.custom_liveroom_more_background), null);
        this.q.a(msglistActivity);
        this.q.a((int) msglistActivity.getResources().getDimension(com.baidu.tieba.s.ds376));
    }

    public void f(boolean z) {
        if (this.q != null) {
            if (z) {
                this.r.b(true);
            } else {
                this.r.b(false);
            }
            this.r.a(this.A);
            this.q.b();
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void A() {
        super.A();
        if (this.q != null) {
            com.baidu.adp.lib.e.e.a(this.q, this.v);
        }
    }

    public void g(boolean z) {
        if (this.q != null) {
            if (z) {
                this.r.b(true);
            } else {
                this.r.b(false);
            }
            this.r.a(this.A);
            synchronized (this.q) {
                this.q.notify();
            }
            new Handler().postDelayed(new aw(this), 200L);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(int i) {
        super.a(i);
        if (this.q != null) {
            this.q.a(this.f, i, this.f.getResources().getDrawable(com.baidu.tieba.r.custom_liveroom_more_background), this.f.getResources().getDrawable(com.baidu.tieba.r.custom_liveroom_more_background_1));
        }
    }
}
