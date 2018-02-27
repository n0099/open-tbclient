package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String bzZ = "dalvikvm";
    private String[] bAa = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c bAb = null;
    private int bzS = 0;
    private final int bAc = 10000;
    private a bAd = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler bAe = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.bAd != null) {
                e.this.bAd.ig(e.this.bzS);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ig(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!jP()) {
            super.start();
            this.bAe.sendEmptyMessageDelayed(0, 10000L);
            Ok();
            try {
                c.a(this.bzZ, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void ha(String str) {
                        for (int i = 0; i < e.this.bAa.length; i++) {
                            if (str.contains(e.this.bAa[i])) {
                                e.this.bzS++;
                                return;
                            }
                        }
                    }
                });
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Ol();
    }

    private void Ok() {
        if (this.bAb == null) {
            this.bAb = new c();
        }
        if (!this.bAb.jP()) {
            new Thread(this.bAb).start();
        }
    }

    private void Ol() {
        if (this.bAb != null && this.bAb.jP()) {
            this.bAb.stop();
        }
    }

    public void a(a aVar) {
        if (this.bAd == null) {
            this.bAd = aVar;
        }
    }
}
