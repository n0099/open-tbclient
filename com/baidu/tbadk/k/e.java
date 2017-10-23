package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aIz = "dalvikvm";
    private String[] aIA = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aIB = null;
    private int aIs = 0;
    private final int aIC = 10000;
    private a aID = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aIE = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aID != null) {
                e.this.aID.fp(e.this.aIs);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fp(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aIE.sendEmptyMessageDelayed(0, 10000L);
            FL();
            try {
                c.a(this.aIz, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gv(String str) {
                        for (int i = 0; i < e.this.aIA.length; i++) {
                            if (str.contains(e.this.aIA[i])) {
                                e.this.aIs++;
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
        FM();
    }

    private void FL() {
        if (this.aIB == null) {
            this.aIB = new c();
        }
        if (!this.aIB.ck()) {
            new Thread(this.aIB).start();
        }
    }

    private void FM() {
        if (this.aIB != null && this.aIB.ck()) {
            this.aIB.stop();
        }
    }

    public void a(a aVar) {
        if (this.aID == null) {
            this.aID = aVar;
        }
    }
}
