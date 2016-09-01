package com.baidu.tieba.frs.entelechy.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements MediaPlayer.OnErrorListener {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bXm = aVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.bXm.Nz();
        this.bXm.d(true, 4);
        return true;
    }
}
