package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aQc;
    private List<String> aQd = new ArrayList();
    private Object mLock = new Object();
    private boolean aQe = false;
    private byte[] aQg = new byte[1024];
    private Runnable CJ = new b(this);
    private Thread aQf = new Thread(this.CJ);

    private a() {
        this.aQf.start();
    }

    public static a Kt() {
        if (aQc == null) {
            synchronized (a.class) {
                if (aQc == null) {
                    aQc = new a();
                }
            }
        }
        return aQc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Ku() {
        return this.aQd.isEmpty() ? null : this.aQd.get(0);
    }

    public synchronized void hb(String str) {
        this.aQd.clear();
        this.aQd.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
