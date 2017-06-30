package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aUw;
    private List<String> aUx = new ArrayList();
    private Object mLock = new Object();
    private boolean aUy = false;
    private byte[] mBuffer = new byte[1024];
    private Runnable aEN = new b(this);
    private Thread mThread = new Thread(this.aEN);

    private a() {
        this.mThread.start();
    }

    public static a Ku() {
        if (aUw == null) {
            synchronized (a.class) {
                if (aUw == null) {
                    aUw = new a();
                }
            }
        }
        return aUw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Kv() {
        return this.aUx.isEmpty() ? null : this.aUx.get(0);
    }

    public synchronized void hl(String str) {
        this.aUx.clear();
        this.aUx.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
