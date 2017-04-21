package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ v aRa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar) {
        this.aRa = vVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.aRa.notifyOnVideoSizeChanged(i, i2, 0, 0);
    }
}
