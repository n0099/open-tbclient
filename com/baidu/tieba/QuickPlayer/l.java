package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements IMediaPlayer.OnInfoListener {
    final /* synthetic */ h aQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.aQj = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aQj.aQg;
            if (cVar != null) {
                cVar2 = this.aQj.aQg;
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
