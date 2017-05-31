package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ x aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.aRw = xVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.aRw.notifyOnVideoSizeChanged(i, i2, 0, 0);
    }
}
