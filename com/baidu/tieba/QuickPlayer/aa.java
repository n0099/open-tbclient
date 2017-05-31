package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnSeekCompleteListener {
    final /* synthetic */ x aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.aRw = xVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.aRw.notifyOnSeekComplete();
    }
}
