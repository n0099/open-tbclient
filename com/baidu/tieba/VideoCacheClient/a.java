package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aVe;
    private List<String> aVf = new ArrayList();
    private Object mLock = new Object();
    private boolean aVg = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable IJ = new b(this);
    private Thread aVh = new Thread(this.IJ);

    private a() {
        this.aVh.start();
    }

    public static a LN() {
        if (aVe == null) {
            synchronized (a.class) {
                if (aVe == null) {
                    aVe = new a();
                }
            }
        }
        return aVe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String LO() {
        return this.aVf.isEmpty() ? null : this.aVf.get(0);
    }

    public synchronized void gV(String str) {
        this.aVf.clear();
        this.aVf.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
