package com.baidu.tieba.QuickPlayer;

import android.os.RemoteException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements IMediaPlayer.OnErrorListener {
    final /* synthetic */ e aLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aLo = eVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        b bVar;
        b bVar2;
        int i3;
        try {
            bVar = this.aLo.aLk;
            if (bVar != null) {
                bVar2 = this.aLo.aLk;
                i3 = this.aLo.aLl;
                bVar2.q(i3, i, i2);
                return true;
            }
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        }
    }
}
