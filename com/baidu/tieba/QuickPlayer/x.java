package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ v aLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.aLV = vVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.aLV.notifyOnCompletion();
    }
}
