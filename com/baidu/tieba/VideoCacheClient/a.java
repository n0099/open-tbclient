package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aNw;
    private List<String> aNx = new ArrayList();
    private Object mLock = new Object();
    private boolean aNy = false;
    private byte[] aNA = new byte[1024];
    private Runnable CI = new b(this);
    private Thread aNz = new Thread(this.CI);

    private a() {
        this.aNz.start();
    }

    public static a JK() {
        if (aNw == null) {
            synchronized (a.class) {
                if (aNw == null) {
                    aNw = new a();
                }
            }
        }
        return aNw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String JL() {
        return this.aNx.isEmpty() ? null : this.aNx.get(0);
    }

    public synchronized void gY(String str) {
        this.aNx.clear();
        this.aNx.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
