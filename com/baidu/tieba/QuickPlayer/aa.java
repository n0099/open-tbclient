package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnErrorListener {
    final /* synthetic */ v aQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.aQY = vVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.aQY.notifyOnError(i, i2);
        return true;
    }
}
