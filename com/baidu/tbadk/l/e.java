package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJJ = "dalvikvm";
    private String[] aJK = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJL = null;
    private int aJC = 0;
    private final int aJM = 10000;
    private a aJN = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJO = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJN != null) {
                e.this.aJN.ff(e.this.aJC);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ff(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!cv()) {
            super.start();
            this.aJO.sendEmptyMessageDelayed(0, 10000L);
            Go();
            try {
                c.a(this.aJJ, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gA(String str) {
                        for (int i = 0; i < e.this.aJK.length; i++) {
                            if (str.contains(e.this.aJK[i])) {
                                e.this.aJC++;
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
        Gp();
    }

    private void Go() {
        if (this.aJL == null) {
            this.aJL = new c();
        }
        if (!this.aJL.cv()) {
            new Thread(this.aJL).start();
        }
    }

    private void Gp() {
        if (this.aJL != null && this.aJL.cv()) {
            this.aJL.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJN == null) {
            this.aJN = aVar;
        }
    }
}
