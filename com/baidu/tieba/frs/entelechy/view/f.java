package com.baidu.tieba.frs.entelechy.view;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.tbadk.core.view.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bLV = aVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(0.0f, 0.0f);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                if (at.vG().vL()) {
                    mediaPlayer.seekTo(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler = this.bLV.aUo;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
