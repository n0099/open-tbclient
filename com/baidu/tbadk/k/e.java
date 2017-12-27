package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String bxN = "dalvikvm";
    private String[] bxO = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c bxP = null;
    private int bxG = 0;
    private final int bxQ = 10000;
    private a bxR = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler bxS = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.bxR != null) {
                e.this.bxR.in(e.this.bxG);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void in(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!jP()) {
            super.start();
            this.bxS.sendEmptyMessageDelayed(0, 10000L);
            NP();
            try {
                c.a(this.bxN, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gI(String str) {
                        for (int i = 0; i < e.this.bxO.length; i++) {
                            if (str.contains(e.this.bxO[i])) {
                                e.this.bxG++;
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
        NQ();
    }

    private void NP() {
        if (this.bxP == null) {
            this.bxP = new c();
        }
        if (!this.bxP.jP()) {
            new Thread(this.bxP).start();
        }
    }

    private void NQ() {
        if (this.bxP != null && this.bxP.jP()) {
            this.bxP.stop();
        }
    }

    public void a(a aVar) {
        if (this.bxR == null) {
            this.bxR = aVar;
        }
    }
}
