package com.baidu.tieba.im.live.room.replay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class LiveRoomReplayPlayer extends RelativeLayout {
    private Context a;
    private LayoutInflater b;
    private View c;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private SeekBar h;
    private TextView i;
    private ImageView j;
    private boolean k;
    private int l;
    private SeekBar.OnSeekBarChangeListener m;

    public LiveRoomReplayPlayer(Context context) {
        super(context);
        this.k = false;
        this.l = 0;
        this.m = new i(this);
        a(context);
    }

    public LiveRoomReplayPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = 0;
        this.m = new i(this);
        a(context);
    }

    public LiveRoomReplayPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = false;
        this.l = 0;
        this.m = new i(this);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = this.b.inflate(w.live_room_replay_player, (ViewGroup) this, true);
        this.d = (HeadImageView) this.c.findViewById(v.live_room_replay_player_hosthead);
        this.d.setIsRound(true);
        this.e = (TextView) this.c.findViewById(v.live_room_replay_player_hostname);
        this.f = (TextView) this.c.findViewById(v.live_room_replay_player_hostlike);
        this.g = (TextView) this.c.findViewById(v.live_chat_room_player_position);
        this.i = (TextView) this.c.findViewById(v.live_chat_room_player_duration);
        this.j = (ImageView) this.c.findViewById(v.live_room_replay_player_pauseorplay);
        j.a(this.a, this.j, 10, 10, 10, 10);
        this.h = (SeekBar) this.c.findViewById(v.live_room_replay_player_seekbar);
        this.h.setOnSeekBarChangeListener(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeadImageView getHeadView() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getNameView() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getLikeView() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SeekBar getPlayerBar() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getPlayerDur() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView getPauseOrPlayView() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNeedKeepDragPosition(boolean z) {
        this.k = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextStartPosition() {
        int i = this.l;
        this.l = 0;
        return i;
    }
}
