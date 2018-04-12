package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aKy = "dalvikvm";
    private String[] aKz = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aKA = null;
    private int aKr = 0;
    private final int aKB = 10000;
    private a aKC = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aKD = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aKC != null) {
                e.this.aKC.fg(e.this.aKr);
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
            this.aKD.sendEmptyMessageDelayed(0, 10000L);
            GN();
            try {
                c.a(this.aKy, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gP(String str) {
                        for (int i = 0; i < e.this.aKz.length; i++) {
                            if (str.contains(e.this.aKz[i])) {
                                e.this.aKr++;
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
        GO();
    }

    private void GN() {
        if (this.aKA == null) {
            this.aKA = new c();
        }
        if (!this.aKA.bT()) {
            new Thread(this.aKA).start();
        }
    }

    private void GO() {
        if (this.aKA != null && this.aKA.bT()) {
            this.aKA.stop();
        }
    }

    public void a(a aVar) {
        if (this.aKC == null) {
            this.aKC = aVar;
        }
    }
}
