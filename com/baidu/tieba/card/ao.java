package com.baidu.tieba.card;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements MediaPlayer.OnErrorListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.aTK = alVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.aTK.ca(true);
        return true;
    }
}
