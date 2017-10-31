package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJj = "dalvikvm";
    private String[] aJk = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJl = null;
    private int aJc = 0;
    private final int aJm = 10000;
    private a aJn = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJo = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJn != null) {
                e.this.aJn.fq(e.this.aJc);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fq(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aJo.sendEmptyMessageDelayed(0, 10000L);
            FX();
            try {
                c.a(this.aJj, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gC(String str) {
                        for (int i = 0; i < e.this.aJk.length; i++) {
                            if (str.contains(e.this.aJk[i])) {
                                e.this.aJc++;
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
        FY();
    }

    private void FX() {
        if (this.aJl == null) {
            this.aJl = new c();
        }
        if (!this.aJl.ck()) {
            new Thread(this.aJl).start();
        }
    }

    private void FY() {
        if (this.aJl != null && this.aJl.ck()) {
            this.aJl.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJn == null) {
            this.aJn = aVar;
        }
    }
}
