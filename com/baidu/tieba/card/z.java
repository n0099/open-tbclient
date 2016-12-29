package com.baidu.tieba.card;

import android.os.Handler;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements t.d {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar) {
        this.bcw = tVar;
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
            handler = this.bcw.aOr;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
