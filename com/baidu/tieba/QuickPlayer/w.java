package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ v aLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aLV = vVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.aLV.notifyOnPrepared();
    }
}
