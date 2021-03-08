package com.baidu.tbadk.f;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.n.a.b;
/* loaded from: classes.dex */
public class a extends Thread {
    public a(String str) {
        super(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this) {
            bkp();
        }
    }

    private void bkp() {
        float f = 10.0f;
        double nanoTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            f = f + 1.9509029f + 98.90882f + 1998.158f + 989.98895f + 1.1599002f + 16.2098f + 8899.087f + i;
        }
        BdLog.e("res" + f);
        TbSingleton.getInstance().setCpuFlopsDuration((int) ((System.nanoTime() - nanoTime) / 1000000.0d));
        b.log();
    }

    public static void bkq() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tbadk.f.a.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                try {
                    new a("BenchmarkThread").start();
                    return false;
                } catch (Exception e) {
                    BdLog.e(e);
                    return false;
                }
            }
        });
    }
}
