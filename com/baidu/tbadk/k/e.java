package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String bAc = "dalvikvm";
    private String[] bAd = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c bAe = null;
    private int bzV = 0;
    private final int bAf = 10000;
    private a bAg = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler bAh = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.bAg != null) {
                e.this.bAg.ig(e.this.bzV);
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
            this.bAh.sendEmptyMessageDelayed(0, 10000L);
            Ol();
            try {
                c.a(this.bAc, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void ha(String str) {
                        for (int i = 0; i < e.this.bAd.length; i++) {
                            if (str.contains(e.this.bAd[i])) {
                                e.this.bzV++;
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
        Om();
    }

    private void Ol() {
        if (this.bAe == null) {
            this.bAe = new c();
        }
        if (!this.bAe.jP()) {
            new Thread(this.bAe).start();
        }
    }

    private void Om() {
        if (this.bAe != null && this.bAe.jP()) {
            this.bAe.stop();
        }
    }

    public void a(a aVar) {
        if (this.bAg == null) {
            this.bAg = aVar;
        }
    }
}
