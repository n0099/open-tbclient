package com.baidu.tieba.im.live.room.replay;

import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class j implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ LiveRoomReplayPlayer a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LiveRoomReplayPlayer liveRoomReplayPlayer) {
        this.a = liveRoomReplayPlayer;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        boolean z;
        int progress = seekBar.getProgress();
        BdLog.d("Drag stopped " + progress);
        if (progress != this.b) {
            z = this.a.k;
            if (z) {
                this.a.l = progress;
            }
            com.baidu.tieba.im.live.b.b().a(progress);
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
        textView = this.a.g;
        textView.setText(translateSecondsToString);
    }
}
