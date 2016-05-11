package com.baidu.tieba.frs.entelechy.c;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements MediaPlayer.OnErrorListener {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bpG = aVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.bpG.SL();
        this.bpG.e(true, 4);
        return true;
    }
}
