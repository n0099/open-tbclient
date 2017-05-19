package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements MediaPlayer.OnErrorListener {
    final /* synthetic */ x aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.aRv = xVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.aRv.notifyOnError(i, i2);
        return true;
    }
}
