package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ x aSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.aSP = xVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.aSP.notifyOnPrepared();
    }
}
