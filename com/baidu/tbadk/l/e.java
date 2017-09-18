package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJl = "dalvikvm";
    private String[] aJm = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJn = null;
    private int aJe = 0;
    private final int aJo = 10000;
    private a aJp = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJq = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJp != null) {
                e.this.aJp.ff(e.this.aJe);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ff(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aJq.sendEmptyMessageDelayed(0, 10000L);
            Gm();
            try {
                c.a(this.aJl, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gz(String str) {
                        for (int i = 0; i < e.this.aJm.length; i++) {
                            if (str.contains(e.this.aJm[i])) {
                                e.this.aJe++;
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
        Gn();
    }

    private void Gm() {
        if (this.aJn == null) {
            this.aJn = new c();
        }
        if (!this.aJn.ck()) {
            new Thread(this.aJn).start();
        }
    }

    private void Gn() {
        if (this.aJn != null && this.aJn.ck()) {
            this.aJn.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJp == null) {
            this.aJp = aVar;
        }
    }
}
