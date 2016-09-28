package com.baidu.tieba.card;

import android.os.Handler;
import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements e.d {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.aZW = rVar;
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
            handler = this.aZW.aZR;
            handler.sendEmptyMessageDelayed(202, 300L);
        }
    }
}
