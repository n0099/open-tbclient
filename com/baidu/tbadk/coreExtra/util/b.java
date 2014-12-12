package com.baidu.tbadk.coreExtra.util;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ TbCountDownTimer Td;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TbCountDownTimer tbCountDownTimer) {
        this.Td = tbCountDownTimer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long j;
        long j2;
        long j3;
        long j4;
        synchronized (this.Td) {
            j = this.Td.mStopTimeInFuture;
            long elapsedRealtime = j - SystemClock.elapsedRealtime();
            if (elapsedRealtime > 0) {
                j2 = this.Td.mCountdownInterval;
                if (elapsedRealtime < j2) {
                    this.Td.onTick(0L);
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.Td.onTick(elapsedRealtime);
                    j3 = this.Td.mCountdownInterval;
                    long elapsedRealtime3 = (j3 + elapsedRealtime2) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        j4 = this.Td.mCountdownInterval;
                        elapsedRealtime3 += j4;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            } else {
                this.Td.onFinish();
            }
        }
    }
}
