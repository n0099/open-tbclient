package com.baidu.tieba.card;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements MediaPlayer.OnErrorListener {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.aQe = zVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.aQe.e(true, 4);
        return true;
    }
}
