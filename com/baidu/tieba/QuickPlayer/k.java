package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements IMediaPlayer.OnErrorListener {
    final /* synthetic */ h aLw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.aLw = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aLw.aLt;
            if (cVar != null) {
                cVar2 = this.aLw.aLt;
                cVar2.N(i, i2);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
