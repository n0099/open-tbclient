package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aKz = "dalvikvm";
    private String[] aKA = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aKB = null;
    private int aKs = 0;
    private final int aKC = 10000;
    private a aKD = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aKE = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aKD != null) {
                e.this.aKD.fg(e.this.aKs);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fg(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!bT()) {
            super.start();
            this.aKE.sendEmptyMessageDelayed(0, 10000L);
            GL();
            try {
                c.a(this.aKz, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gP(String str) {
                        for (int i = 0; i < e.this.aKA.length; i++) {
                            if (str.contains(e.this.aKA[i])) {
                                e.this.aKs++;
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
        GM();
    }

    private void GL() {
        if (this.aKB == null) {
            this.aKB = new c();
        }
        if (!this.aKB.bT()) {
            new Thread(this.aKB).start();
        }
    }

    private void GM() {
        if (this.aKB != null && this.aKB.bT()) {
            this.aKB.stop();
        }
    }

    public void a(a aVar) {
        if (this.aKD == null) {
            this.aKD = aVar;
        }
    }
}
