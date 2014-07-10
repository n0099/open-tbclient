package com.baidu.tieba.im.live;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        int i2;
        int i3;
        i = this.a.e;
        if (i > 0) {
            this.a.e = 0;
            handler = this.a.t;
            handler.postDelayed(this, 20000L);
            i2 = this.a.f;
            if (i2 < 2) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_no_stream_retry);
                d dVar = this.a;
                i3 = dVar.f;
                dVar.f = i3 + 1;
                this.a.p();
                return;
            }
            UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_no_stream);
            this.a.f = 0;
            this.a.s();
            return;
        }
        this.a.g = false;
        this.a.e = 0;
        this.a.f = 0;
    }
}
