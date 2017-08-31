package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a {
    private String aJo = "dalvikvm";
    private String[] aJp = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private c aJq = null;
    private int aJh = 0;
    private final int aJr = 10000;
    private a aJs = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler aJt = new Handler() { // from class: com.baidu.tbadk.l.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.aJs != null) {
                e.this.aJs.ff(e.this.aJh);
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
            this.aJt.sendEmptyMessageDelayed(0, 10000L);
            Gm();
            try {
                c.a(this.aJo, new b() { // from class: com.baidu.tbadk.l.e.2
                    @Override // com.baidu.tbadk.l.b
                    public void gz(String str) {
                        for (int i = 0; i < e.this.aJp.length; i++) {
                            if (str.contains(e.this.aJp[i])) {
                                e.this.aJh++;
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
        if (this.aJq == null) {
            this.aJq = new c();
        }
        if (!this.aJq.ck()) {
            new Thread(this.aJq).start();
        }
    }

    private void Gn() {
        if (this.aJq != null && this.aJq.ck()) {
            this.aJq.stop();
        }
    }

    public void a(a aVar) {
        if (this.aJs == null) {
            this.aJs = aVar;
        }
    }
}
