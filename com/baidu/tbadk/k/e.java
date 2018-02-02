package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String byf = "dalvikvm";
    private String[] byg = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c byh = null;
    private int bxY = 0;
    private final int byi = 10000;
    private a byj = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler byk = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.byj != null) {
                e.this.byj.ij(e.this.bxY);
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
            this.byk.sendEmptyMessageDelayed(0, 10000L);
            NF();
            try {
                c.a(this.byf, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gR(String str) {
                        for (int i = 0; i < e.this.byg.length; i++) {
                            if (str.contains(e.this.byg[i])) {
                                e.this.bxY++;
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
        NG();
    }

    private void NF() {
        if (this.byh == null) {
            this.byh = new c();
        }
        if (!this.byh.jP()) {
            new Thread(this.byh).start();
        }
    }

    private void NG() {
        if (this.byh != null && this.byh.jP()) {
            this.byh.stop();
        }
    }

    public void a(a aVar) {
        if (this.byj == null) {
            this.byj = aVar;
        }
    }
}
