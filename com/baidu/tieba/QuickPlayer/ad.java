package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements MediaPlayer.OnInfoListener {
    final /* synthetic */ x aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.aRv = xVar;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        this.aRv.notifyOnInfo(i, i2);
        return true;
    }
}
