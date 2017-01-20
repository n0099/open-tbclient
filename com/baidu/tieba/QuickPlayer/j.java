package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements IMediaPlayer.OnCompletionListener {
    final /* synthetic */ h aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.aKy = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aKy.aKv;
            if (cVar != null) {
                cVar2 = this.aKy.aKv;
                cVar2.IT();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
