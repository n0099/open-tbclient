package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements IMediaPlayer.OnInfoListener {
    final /* synthetic */ e aLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.aLo = eVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        b bVar;
        b bVar2;
        int i3;
        try {
            bVar = this.aLo.aLk;
            if (bVar != null) {
                bVar2 = this.aLo.aLk;
                i3 = this.aLo.aLl;
                bVar2.r(i3, i, i2);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
