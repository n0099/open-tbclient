package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJW = "dalvikvm";
    private String[] aJX = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJY = null;
    private int aJP = 0;
    private final int aJZ = 10000;
    private a aKa = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aKb = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aKa != null) {
                e.this.aKa.fo(e.this.aJP);
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
            this.aKb.sendEmptyMessageDelayed(0, 10000L);
            Gq();
            try {
                c.a(this.aJW, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gF(String str) {
                        for (int i = 0; i < e.this.aJX.length; i++) {
                            if (str.contains(e.this.aJX[i])) {
                                e.this.aJP++;
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
        Gr();
    }

    private void Gq() {
        if (this.aJY == null) {
            this.aJY = new c();
        }
        if (!this.aJY.ck()) {
            new Thread(this.aJY).start();
        }
    }

    private void Gr() {
        if (this.aJY != null && this.aJY.ck()) {
            this.aJY.stop();
        }
    }

    public void a(a aVar) {
        if (this.aKa == null) {
            this.aKa = aVar;
        }
    }
}
