package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements MediaPlayer.OnSeekCompleteListener {
    final /* synthetic */ p aLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.aLK = pVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.aLK.notifyOnSeekComplete();
    }
}
