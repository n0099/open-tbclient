package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aVg;
    private List<String> aVh = new ArrayList();
    private Object mLock = new Object();
    private boolean aVi = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable IL = new b(this);
    private Thread aVj = new Thread(this.IL);

    private a() {
        this.aVj.start();
    }

    public static a LN() {
        if (aVg == null) {
            synchronized (a.class) {
                if (aVg == null) {
                    aVg = new a();
                }
            }
        }
        return aVg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String LO() {
        return this.aVh.isEmpty() ? null : this.aVh.get(0);
    }

    public synchronized void gV(String str) {
        this.aVh.clear();
        this.aVh.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
