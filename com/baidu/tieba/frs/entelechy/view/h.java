package com.baidu.tieba.frs.entelechy.view;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.tbadk.core.view.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bXm = aVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(0.0f, 0.0f);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                if (au.wK().wP()) {
                    mediaPlayer.seekTo(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler = this.bXm.aZx;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
