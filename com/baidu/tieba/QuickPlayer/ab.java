package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnInfoListener {
    final /* synthetic */ v aRa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.aRa = vVar;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        this.aRa.notifyOnInfo(i, i2);
        return true;
    }
}
