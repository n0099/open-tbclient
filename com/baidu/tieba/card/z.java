package com.baidu.tieba.card;

import android.media.MediaPlayer;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar) {
        this.aZF = tVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(0.0f, 0.0f);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                if (com.baidu.tbadk.core.view.au.wK().wP()) {
                    mediaPlayer.seekTo(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler = this.aZF.aZx;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
