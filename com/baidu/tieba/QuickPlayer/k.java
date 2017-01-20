package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements IMediaPlayer.OnErrorListener {
    final /* synthetic */ h aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.aKy = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aKy.aKv;
            if (cVar != null) {
                cVar2 = this.aKy.aKv;
                cVar2.O(i, i2);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
