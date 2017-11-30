package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJS = "dalvikvm";
    private String[] aJT = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJU = null;
    private int aJL = 0;
    private final int aJV = 10000;
    private a aJW = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJX = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJW != null) {
                e.this.aJW.fo(e.this.aJL);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fo(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aJX.sendEmptyMessageDelayed(0, 10000L);
            Gp();
            try {
                c.a(this.aJS, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gG(String str) {
                        for (int i = 0; i < e.this.aJT.length; i++) {
                            if (str.contains(e.this.aJT[i])) {
                                e.this.aJL++;
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
        Gq();
    }

    private void Gp() {
        if (this.aJU == null) {
            this.aJU = new c();
        }
        if (!this.aJU.ck()) {
            new Thread(this.aJU).start();
        }
    }

    private void Gq() {
        if (this.aJU != null && this.aJU.ck()) {
            this.aJU.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJW == null) {
            this.aJW = aVar;
        }
    }
}
