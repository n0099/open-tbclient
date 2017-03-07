package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements IMediaPlayer.OnPreparedListener {
    final /* synthetic */ h aQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aQj = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aQj.aQg;
            if (cVar != null) {
                cVar2 = this.aQj.aQg;
                cVar2.Jx();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
