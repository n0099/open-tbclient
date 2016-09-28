package com.baidu.tieba.QuickPlayer;

import android.os.RemoteException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements IMediaPlayer.OnPreparedListener {
    final /* synthetic */ e aLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aLo = eVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        b bVar;
        b bVar2;
        int i;
        try {
            bVar = this.aLo.aLk;
            if (bVar != null) {
                bVar2 = this.aLo.aLk;
                i = this.aLo.aLl;
                bVar2.fF(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
