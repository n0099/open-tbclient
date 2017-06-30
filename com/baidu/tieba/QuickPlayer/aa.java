package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnSeekCompleteListener {
    final /* synthetic */ x aSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.aSP = xVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.aSP.notifyOnSeekComplete();
    }
}
