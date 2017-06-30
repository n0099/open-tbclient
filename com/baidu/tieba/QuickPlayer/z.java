package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ x aSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.aSP = xVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.aSP.notifyOnCompletion();
    }
}
