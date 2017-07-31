package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJI = "dalvikvm";
    private String[] aJJ = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJK = null;
    private int aJB = 0;
    private final int aJL = 10000;
    private a aJM = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJN = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJM != null) {
                e.this.aJM.ff(e.this.aJB);
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
            this.aJN.sendEmptyMessageDelayed(0, 10000L);
            Go();
            try {
                c.a(this.aJI, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gA(String str) {
                        for (int i = 0; i < e.this.aJJ.length; i++) {
                            if (str.contains(e.this.aJJ[i])) {
                                e.this.aJB++;
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
        if (this.aJK == null) {
            this.aJK = new c();
        }
        if (!this.aJK.cv()) {
            new Thread(this.aJK).start();
        }
    }

    private void Gp() {
        if (this.aJK != null && this.aJK.cv()) {
            this.aJK.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJM == null) {
            this.aJM = aVar;
        }
    }
}
