package com.baidu.tieba.card;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.location.a0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.aTK = alVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            handler = this.aTK.aTH;
            handler.sendEmptyMessageDelayed(a0.f37long, 300L);
        }
    }
}
