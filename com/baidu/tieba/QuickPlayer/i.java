package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements IMediaPlayer.OnPreparedListener {
    final /* synthetic */ h aMf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aMf = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aMf.aMc;
            if (cVar != null) {
                cVar2 = this.aMf.aMc;
                cVar2.Jk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
