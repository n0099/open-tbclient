package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String bxW = "dalvikvm";
    private String[] bxX = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c bxY = null;
    private int bxP = 0;
    private final int bxZ = 10000;
    private a bya = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler byb = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.bya != null) {
                e.this.bya.ij(e.this.bxP);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ij(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!jP()) {
            super.start();
            this.byb.sendEmptyMessageDelayed(0, 10000L);
            ND();
            try {
                c.a(this.bxW, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gJ(String str) {
                        for (int i = 0; i < e.this.bxX.length; i++) {
                            if (str.contains(e.this.bxX[i])) {
                                e.this.bxP++;
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
        NE();
    }

    private void ND() {
        if (this.bxY == null) {
            this.bxY = new c();
        }
        if (!this.bxY.jP()) {
            new Thread(this.bxY).start();
        }
    }

    private void NE() {
        if (this.bxY != null && this.bxY.jP()) {
            this.bxY.stop();
        }
    }

    public void a(a aVar) {
        if (this.bya == null) {
            this.bya = aVar;
        }
    }
}
