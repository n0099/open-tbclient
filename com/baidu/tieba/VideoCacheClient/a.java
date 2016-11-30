package com.baidu.tieba.VideoCacheClient;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static a aQL;
    private List<String> aQM = new ArrayList();
    private Object mLock = new Object();
    private boolean aQN = false;
    private byte[] aQP = new byte[1024];
    private Runnable CI = new b(this);
    private Thread aQO = new Thread(this.CI);

    private a() {
        this.aQO.start();
    }

    public static a La() {
        if (aQL == null) {
            synchronized (a.class) {
                if (aQL == null) {
                    aQL = new a();
                }
            }
        }
        return aQL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String Lb() {
        return this.aQM.isEmpty() ? null : this.aQM.get(0);
    }

    public synchronized void hg(String str) {
        this.aQM.clear();
        this.aQM.add(str);
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }
}
