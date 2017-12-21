package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJZ = "dalvikvm";
    private String[] aKa = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aKb = null;
    private int aJS = 0;
    private final int aKc = 10000;
    private a aKd = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aKe = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aKd != null) {
                e.this.aKd.fo(e.this.aJS);
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
            this.aKe.sendEmptyMessageDelayed(0, 10000L);
            Gq();
            try {
                c.a(this.aJZ, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gF(String str) {
                        for (int i = 0; i < e.this.aKa.length; i++) {
                            if (str.contains(e.this.aKa[i])) {
                                e.this.aJS++;
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
        if (this.aKb == null) {
            this.aKb = new c();
        }
        if (!this.aKb.ck()) {
            new Thread(this.aKb).start();
        }
    }

    private void Gr() {
        if (this.aKb != null && this.aKb.ck()) {
            this.aKb.stop();
        }
    }

    public void a(a aVar) {
        if (this.aKd == null) {
            this.aKd = aVar;
        }
    }
}
