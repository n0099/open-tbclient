package com.baidu.tieba.im.live.room;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.view.LocateScrollView;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.f {
    private Button a;
    private EditText b;
    private LiveRoomEntranceActivity c;
    private NavigationBar d;
    private View e;
    private ImageView f;
    private LocateScrollView g;
    private LiveRoomEntranceRelativeLayout h;
    private LinearLayout i;
    private Bitmap j;
    private Bitmap k;
    private com.baidu.tieba.im.view.k l;

    public void a() {
        HidenSoftKeyPad(this.b);
    }

    public View b() {
        return this.e;
    }

    public EditText c() {
        return this.b;
    }

    public Button d() {
        return this.a;
    }

    public ImageView e() {
        return this.f;
    }

    public void a(int i) {
        this.d.c(0);
    }

    public bb(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        super(liveRoomEntranceActivity);
        this.c = liveRoomEntranceActivity;
        liveRoomEntranceActivity.setContentView(com.baidu.tieba.v.activity_live_entrance);
        this.d = (NavigationBar) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.lay_title_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, liveRoomEntranceActivity);
        this.d.a(com.baidu.tieba.x.liveroom);
        this.f = (ImageView) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.live_room_entrance_spot);
        this.a = (Button) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.btnEnter);
        this.l = new bc(this, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds20));
        this.g = (LocateScrollView) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.live_room_entrance_scrollview);
        this.g.setOnSizeChangeListener(this.l);
        this.h = (LiveRoomEntranceRelativeLayout) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.live_room_entrance_layout);
        this.j = com.baidu.tbadk.core.util.d.a(this.mContext, com.baidu.tieba.t.bg_live_room);
        if (this.j != null) {
            this.h.setBackgroundDrawable(new BitmapDrawable(this.c.getResources(), this.j));
        }
        this.i = (LinearLayout) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.live_room_entrance_anim_lay);
        this.k = com.baidu.tbadk.core.util.d.b(this.mContext, com.baidu.tieba.t.live_room_enterance_anim_bg);
        if (this.k != null) {
            this.i.setBackgroundDrawable(new BitmapDrawable(this.c.getResources(), this.k));
        }
        this.b = (EditText) liveRoomEntranceActivity.findViewById(com.baidu.tieba.u.homenameedit);
        this.a.setOnClickListener(liveRoomEntranceActivity);
        this.b.addTextChangedListener(new bd(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.h != null) {
            this.h.setBackgroundDrawable(null);
        }
        if (this.j != null && !this.j.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
        if (this.i != null) {
            this.i.setBackgroundDrawable(null);
        }
        if (this.k != null && !this.k.isRecycled()) {
            this.k.recycle();
            this.k = null;
        }
    }
}
