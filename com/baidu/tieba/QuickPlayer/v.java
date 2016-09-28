package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements MediaPlayer.OnInfoListener {
    final /* synthetic */ p aLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.aLK = pVar;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        this.aLK.notifyOnInfo(i, i2);
        return true;
    }
}
