package com.baidu.tieba.card;

import android.os.Handler;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements v.d {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar) {
        this.bBb = yVar;
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
            handler = this.bBb.bAS;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
