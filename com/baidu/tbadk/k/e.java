package com.baidu.tbadk.k;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aIM = "dalvikvm";
    private String[] aIN = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aIO = null;
    private int aIF = 0;
    private final int aIP = 10000;
    private a aIQ = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aIR = new Handler() { // from class: com.baidu.tbadk.k.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aIQ != null) {
                e.this.aIQ.fq(e.this.aIF);
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
            this.aIR.sendEmptyMessageDelayed(0, 10000L);
            FR();
            try {
                c.a(this.aIM, new b() { // from class: com.baidu.tbadk.k.e.2
                    @Override // com.baidu.tbadk.k.b
                    public void gw(String str) {
                        for (int i = 0; i < e.this.aIN.length; i++) {
                            if (str.contains(e.this.aIN[i])) {
                                e.this.aIF++;
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
        FS();
    }

    private void FR() {
        if (this.aIO == null) {
            this.aIO = new c();
        }
        if (!this.aIO.ck()) {
            new Thread(this.aIO).start();
        }
    }

    private void FS() {
        if (this.aIO != null && this.aIO.ck()) {
            this.aIO.stop();
        }
    }

    public void a(a aVar) {
        if (this.aIQ == null) {
            this.aIQ = aVar;
        }
    }
}
