package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJK = "dalvikvm";
    private String[] aJL = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJM = null;
    private int aJD = 0;
    private final int aJN = 10000;
    private a aJO = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJP = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJO != null) {
                e.this.aJO.ff(e.this.aJD);
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
            this.aJP.sendEmptyMessageDelayed(0, 10000L);
            Go();
            try {
                c.a(this.aJK, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gD(String str) {
                        for (int i = 0; i < e.this.aJL.length; i++) {
                            if (str.contains(e.this.aJL[i])) {
                                e.this.aJD++;
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
        if (this.aJM == null) {
            this.aJM = new c();
        }
        if (!this.aJM.cv()) {
            new Thread(this.aJM).start();
        }
    }

    private void Gp() {
        if (this.aJM != null && this.aJM.cv()) {
            this.aJM.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJO == null) {
            this.aJO = aVar;
        }
    }
}
