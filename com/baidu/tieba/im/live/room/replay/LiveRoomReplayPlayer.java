package com.baidu.tieba.im.live.room.replay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class LiveRoomReplayPlayer extends RelativeLayout {
    private Context a;
    private View b;
    private HeadImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private SeekBar g;
    private TextView h;
    private ImageView i;
    private boolean j;
    private int k;
    private SeekBar.OnSeekBarChangeListener l;

    public LiveRoomReplayPlayer(Context context) {
        super(context);
        this.j = false;
        this.k = 0;
        this.l = new i(this);
        a(context);
    }

    public LiveRoomReplayPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = 0;
        this.l = new i(this);
        a(context);
    }

    public LiveRoomReplayPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = 0;
        this.l = new i(this);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.b = com.baidu.adp.lib.e.b.a().a(context, v.live_room_replay_player, this, true);
        this.c = (HeadImageView) this.b.findViewById(u.live_room_replay_player_hosthead);
        this.c.setIsRound(true);
        this.d = (TextView) this.b.findViewById(u.live_room_replay_player_hostname);
        this.e = (TextView) this.b.findViewById(u.live_room_replay_player_hostlike);
        this.f = (TextView) this.b.findViewById(u.live_chat_room_player_position);
        this.h = (TextView) this.b.findViewById(u.live_chat_room_player_duration);
        this.i = (ImageView) this.b.findViewById(u.live_room_replay_player_pauseorplay);
        j.a(this.a, this.i, 10, 10, 10, 10);
        this.g = (SeekBar) this.b.findViewById(u.live_room_replay_player_seekbar);
        this.g.setOnSeekBarChangeListener(this.l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeadImageView getHeadView() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getNameView() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getLikeView() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SeekBar getPlayerBar() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getPlayerDur() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView getPauseOrPlayView() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNeedKeepDragPosition(boolean z) {
        this.j = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextStartPosition() {
        int i = this.k;
        this.k = 0;
        return i;
    }
}
