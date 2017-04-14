package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements IMediaPlayer.OnPreparedListener {
    final /* synthetic */ h aQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aQz = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aQz.aQw;
            if (cVar != null) {
                cVar2 = this.aQz.aQw;
                cVar2.JX();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
