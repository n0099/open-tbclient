package com.baidu.tieba.frs.entelechy.view;

import android.os.Handler;
import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements e.d {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bXh = aVar;
    }

    @Override // com.baidu.tieba.play.e.d
    public void onPrepared(com.baidu.tieba.play.e eVar) {
        Handler handler;
        if (eVar != null) {
            try {
                eVar.setVolume(0.0f, 0.0f);
                eVar.setLooping(true);
                eVar.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            handler = this.bXh.aZR;
            handler.sendEmptyMessageDelayed(202, 0L);
        }
    }
}
