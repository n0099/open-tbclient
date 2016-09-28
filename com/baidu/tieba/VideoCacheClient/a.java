package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aOF;
    private List<String> aOG = new ArrayList();
    private Object mLock = new Object();
    private boolean aOH = false;
    private byte[] aOJ = new byte[1024];
    private Runnable CI = new b(this);
    private Thread aOI = new Thread(this.CI);

    private a() {
        this.aOI.start();
    }

    public static a Kw() {
        if (aOF == null) {
            synchronized (a.class) {
                if (aOF == null) {
                    aOF = new a();
                }
            }
        }
        return aOF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Kx() {
        return this.aOG.isEmpty() ? null : this.aOG.get(0);
    }

    public synchronized void hf(String str) {
        this.aOG.clear();
        this.aOG.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
