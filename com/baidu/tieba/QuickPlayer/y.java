package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements MediaPlayer.OnSeekCompleteListener {
    final /* synthetic */ v aME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar) {
        this.aME = vVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.aME.notifyOnSeekComplete();
    }
}
