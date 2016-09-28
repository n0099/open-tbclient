package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ p aLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aLK = pVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.aLK.notifyOnPrepared();
    }
}
