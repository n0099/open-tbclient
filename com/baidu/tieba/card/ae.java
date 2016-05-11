package com.baidu.tieba.card;

import android.media.MediaPlayer;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.aQe = zVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            if (com.baidu.tbadk.core.view.at.vD().vI()) {
                mediaPlayer.seekTo(0);
            }
            handler = this.aQe.aPZ;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
