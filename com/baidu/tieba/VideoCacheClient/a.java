package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aPf;
    private List<String> aPg = new ArrayList();
    private Object mLock = new Object();
    private boolean aPh = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable BU = new b(this);
    private Thread aPi = new Thread(this.BU);

    private a() {
        this.aPi.start();
    }

    public static a KI() {
        if (aPf == null) {
            synchronized (a.class) {
                if (aPf == null) {
                    aPf = new a();
                }
            }
        }
        return aPf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String KJ() {
        return this.aPg.isEmpty() ? null : this.aPg.get(0);
    }

    public synchronized void hc(String str) {
        this.aPg.clear();
        this.aPg.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
