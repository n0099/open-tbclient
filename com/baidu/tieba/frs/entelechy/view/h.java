package com.baidu.tieba.frs.entelechy.view;

import android.os.Handler;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements v.d {
    final /* synthetic */ a bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bTp = aVar;
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
            handler = this.bTp.aTw;
            handler.sendEmptyMessageDelayed(202, 0L);
        }
    }
}
