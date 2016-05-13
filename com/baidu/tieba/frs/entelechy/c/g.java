package com.baidu.tieba.frs.entelechy.c;

import android.media.MediaPlayer;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bpG = aVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            if (com.baidu.tbadk.core.view.at.vE().vJ()) {
                mediaPlayer.seekTo(0);
            }
            handler = this.bpG.aPZ;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
