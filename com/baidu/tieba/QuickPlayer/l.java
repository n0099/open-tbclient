package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements IMediaPlayer.OnInfoListener {
    final /* synthetic */ h aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.aQB = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aQB.aQy;
            if (cVar != null) {
                cVar2 = this.aQB.aQy;
                cVar2.U(i, i2);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
