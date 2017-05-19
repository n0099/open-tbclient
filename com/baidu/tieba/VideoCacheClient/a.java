package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aVB;
    private List<String> aVC = new ArrayList();
    private Object mLock = new Object();
    private boolean aVD = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable aDM = new b(this);
    private Thread mThread = new Thread(this.aDM);

    private a() {
        this.mThread.start();
    }

    public static a Lb() {
        if (aVB == null) {
            synchronized (a.class) {
                if (aVB == null) {
                    aVB = new a();
                }
            }
        }
        return aVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Lc() {
        return this.aVC.isEmpty() ? null : this.aVC.get(0);
    }

    public synchronized void gT(String str) {
        this.aVC.clear();
        this.aVC.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
