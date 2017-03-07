package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ v aQI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aQI = vVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.aQI.notifyOnPrepared();
    }
}
