package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ x aSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.aSP = xVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.aSP.notifyOnVideoSizeChanged(i, i2, 0, 0);
    }
}
