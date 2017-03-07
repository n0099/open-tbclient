package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aUR;
    private List<String> aUS = new ArrayList();
    private Object mLock = new Object();
    private boolean aUT = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable Jj = new b(this);
    private Thread aUU = new Thread(this.Jj);

    private a() {
        this.aUU.start();
    }

    public static a Ln() {
        if (aUR == null) {
            synchronized (a.class) {
                if (aUR == null) {
                    aUR = new a();
                }
            }
        }
        return aUR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Lo() {
        return this.aUS.isEmpty() ? null : this.aUS.get(0);
    }

    public synchronized void gR(String str) {
        this.aUS.clear();
        this.aUS.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
