package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJr = "dalvikvm";
    private String[] aJs = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJt = null;
    private int aJk = 0;
    private final int aJu = 10000;
    private a aJv = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJw = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJv != null) {
                e.this.aJv.fp(e.this.aJk);
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
            this.aJw.sendEmptyMessageDelayed(0, 10000L);
            Gi();
            try {
                c.a(this.aJr, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gD(String str) {
                        for (int i = 0; i < e.this.aJs.length; i++) {
                            if (str.contains(e.this.aJs[i])) {
                                e.this.aJk++;
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
        Gj();
    }

    private void Gi() {
        if (this.aJt == null) {
            this.aJt = new c();
        }
        if (!this.aJt.ck()) {
            new Thread(this.aJt).start();
        }
    }

    private void Gj() {
        if (this.aJt != null && this.aJt.ck()) {
            this.aJt.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJv == null) {
            this.aJv = aVar;
        }
    }
}
