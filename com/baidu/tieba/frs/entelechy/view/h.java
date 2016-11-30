package com.baidu.tieba.frs.entelechy.view;

import android.os.Handler;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements t.d {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.cax = aVar;
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
            handler = this.cax.aPa;
            handler.sendEmptyMessageDelayed(202, 0L);
        }
    }
}
