package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ p aLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.aLK = pVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.aLK.notifyOnCompletion();
    }
}
