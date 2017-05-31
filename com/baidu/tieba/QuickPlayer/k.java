package com.baidu.tieba.QuickPlayer;

import com.baidu.sapi2.shell.SapiErrorCode;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements IMediaPlayer.OnErrorListener {
    final /* synthetic */ h aQV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.aQV = hVar;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        boolean Jn;
        int i3;
        c cVar;
        c cVar2;
        try {
            Jn = this.aQV.Jn();
            if (Jn) {
                i3 = -100;
            } else {
                i3 = SapiErrorCode.NETWORK_FAILED;
            }
            cVar = this.aQV.aQS;
            if (cVar != null) {
                cVar2 = this.aQV.aQS;
                cVar2.T(i, i3);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
