package com.baidu.tieba.frs.entelechy.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnErrorListener {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bLV = aVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.bLV.KX();
        this.bLV.e(true, 4);
        return true;
    }
}
