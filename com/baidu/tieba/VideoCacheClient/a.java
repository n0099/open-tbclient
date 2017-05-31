package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aTd;
    private List<String> aTe = new ArrayList();
    private Object mLock = new Object();
    private boolean aTf = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable aDz = new b(this);
    private Thread mThread = new Thread(this.aDz);

    private a() {
        this.mThread.start();
    }

    public static a JW() {
        if (aTd == null) {
            synchronized (a.class) {
                if (aTd == null) {
                    aTd = new a();
                }
            }
        }
        return aTd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String JX() {
        return this.aTe.isEmpty() ? null : this.aTe.get(0);
    }

    public synchronized void gO(String str) {
        this.aTe.clear();
        this.aTe.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
