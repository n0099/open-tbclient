package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements IMediaPlayer.OnPreparedListener {
    final /* synthetic */ h aQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aQU = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aQU.aQR;
            if (cVar != null) {
                cVar2 = this.aQU.aQR;
                cVar2.Jl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
