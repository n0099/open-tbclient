package com.baidu.tieba.card;

import android.os.Handler;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements v.d {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.bsX = xVar;
    }

    @Override // com.baidu.tieba.play.v.d
    public void onPrepared(com.baidu.tieba.play.v vVar) {
        Handler handler;
        if (vVar != null) {
            try {
                vVar.setVolume(0.0f, 0.0f);
                vVar.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler = this.bsX.aTw;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
