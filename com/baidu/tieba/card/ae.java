package com.baidu.tieba.card;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements MediaPlayer.OnErrorListener {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.aUu = zVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.aUu.e(true, 4);
        return true;
    }
}
