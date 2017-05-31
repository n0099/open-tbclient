package com.baidu.tieba.QuickPlayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements IMediaPlayer.OnCompletionListener {
    final /* synthetic */ h aQV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.aQV = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        c cVar;
        c cVar2;
        try {
            cVar = this.aQV.aQS;
            if (cVar != null) {
                cVar2 = this.aQV.aQS;
                cVar2.Jj();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
