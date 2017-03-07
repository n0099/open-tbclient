package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements MediaPlayer.OnSeekCompleteListener {
    final /* synthetic */ v aQI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar) {
        this.aQI = vVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.aQI.notifyOnSeekComplete();
    }
}
