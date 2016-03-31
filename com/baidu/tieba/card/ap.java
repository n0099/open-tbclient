package com.baidu.tieba.card;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.aTK = alVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.aTK.aTF = 0;
        this.aTK.Lo();
    }
}
