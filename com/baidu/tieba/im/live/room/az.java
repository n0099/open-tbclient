package com.baidu.tieba.im.live.room;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.view.LiveRoomEntranceScrollView;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.e {
    public static String a = "live_room_entrance_gif_s.gif";
    public static String b = "live_room_entrance_gif_b.gif";
    private Button c;
    private EditText d;
    private LiveRoomEntranceActivity e;
    private NavigationBar f;
    private View g;
    private ImageView h;
    private LiveRoomEntranceScrollView i;
    private com.baidu.tieba.im.view.l j;

    public void a() {
        HidenSoftKeyPad(this.d);
    }

    public View b() {
        return this.g;
    }

    public EditText c() {
        return this.d;
    }

    public Button d() {
        return this.c;
    }

    public ImageView e() {
        return this.h;
    }

    public void a(int i) {
        this.f.c(0);
    }

    public az(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        super(liveRoomEntranceActivity);
        this.e = liveRoomEntranceActivity;
        liveRoomEntranceActivity.setContentView(com.baidu.tieba.s.activity_live_entrance);
        this.f = (NavigationBar) liveRoomEntranceActivity.findViewById(com.baidu.tieba.r.lay_title_bar);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, liveRoomEntranceActivity);
        this.f.a(com.baidu.tieba.u.liveroom);
        this.h = (ImageView) liveRoomEntranceActivity.findViewById(com.baidu.tieba.r.live_room_entrance_spot);
        this.c = (Button) liveRoomEntranceActivity.findViewById(com.baidu.tieba.r.btnEnter);
        this.j = new ba(this, this.e.getResources().getDimensionPixelSize(com.baidu.tieba.p.ds200));
        this.i = (LiveRoomEntranceScrollView) liveRoomEntranceActivity.findViewById(com.baidu.tieba.r.live_room_entrance_scrollview);
        this.i.setOnSizeChangeListener(this.j);
        this.d = (EditText) liveRoomEntranceActivity.findViewById(com.baidu.tieba.r.homenameedit);
        this.c.setOnClickListener(liveRoomEntranceActivity);
        this.d.addTextChangedListener(new bb(this));
    }
}
