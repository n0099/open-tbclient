package com.baidu.tieba.card;

import android.os.Handler;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements t.d {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.bde = rVar;
    }

    @Override // com.baidu.tieba.play.t.d
    public void onPrepared(com.baidu.tieba.play.t tVar) {
        Handler handler;
        if (tVar != null) {
            try {
                tVar.setVolume(0.0f, 0.0f);
                tVar.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler = this.bde.aPa;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
