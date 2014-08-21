package com.baidu.tieba.im.live.room.replay;

import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class i implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ LiveRoomReplayPlayer a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LiveRoomReplayPlayer liveRoomReplayPlayer) {
        this.a = liveRoomReplayPlayer;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        boolean z;
        int progress = seekBar.getProgress();
        if (progress != this.b) {
            z = this.a.j;
            if (z) {
                this.a.k = progress;
            }
            com.baidu.tieba.im.live.d.b().a(progress);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.b = seekBar.getProgress();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView;
        String translateSecondsToString = StringUtils.translateSecondsToString(seekBar.getProgress());
        textView = this.a.f;
        textView.setText(translateSecondsToString);
    }
}
