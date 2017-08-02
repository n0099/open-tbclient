package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aIt = "dalvikvm";
    private String[] aIu = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aIv = null;
    private int aIm = 0;
    private final int aIw = 10000;
    private a aIx = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aIy = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aIx != null) {
                e.this.aIx.fd(e.this.aIm);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void fd(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aIy.sendEmptyMessageDelayed(0, 10000L);
            Gg();
            try {
                c.a(this.aIt, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gv(String str) {
                        for (int i = 0; i < e.this.aIu.length; i++) {
                            if (str.contains(e.this.aIu[i])) {
                                e.this.aIm++;
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
        Gh();
    }

    private void Gg() {
        if (this.aIv == null) {
            this.aIv = new c();
        }
        if (!this.aIv.ck()) {
            new Thread(this.aIv).start();
        }
    }

    private void Gh() {
        if (this.aIv != null && this.aIv.ck()) {
            this.aIv.stop();
        }
    }

    public void a(a aVar) {
        if (this.aIx == null) {
            this.aIx = aVar;
        }
    }
}
