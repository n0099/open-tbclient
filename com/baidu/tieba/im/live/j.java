package com.baidu.tieba.im.live;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        int i2;
        int i3;
        i = this.a.h;
        if (i > 0) {
            this.a.h = 0;
            handler = this.a.v;
            handler.postDelayed(this, 20000L);
            i2 = this.a.i;
            if (i2 < 2) {
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_no_stream_retry);
                b bVar = this.a;
                i3 = bVar.i;
                bVar.i = i3 + 1;
                this.a.p();
                return;
            }
            UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_no_stream);
            this.a.i = 0;
            this.a.s();
            return;
        }
        this.a.j = false;
        this.a.h = 0;
        this.a.i = 0;
    }
}
