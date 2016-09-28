package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ p aLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.aLK = pVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.aLK.notifyOnVideoSizeChanged(i, i2, 0, 0);
    }
}
