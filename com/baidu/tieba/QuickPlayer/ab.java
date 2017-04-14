package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnInfoListener {
    final /* synthetic */ v aQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.aQY = vVar;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        this.aQY.notifyOnInfo(i, i2);
        return true;
    }
}
